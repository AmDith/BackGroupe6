package ism.atelier.atelier.services.impl;


import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.repository.*;
import ism.atelier.atelier.services.PointageService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PointageServiceImpl implements PointageService {

    private final SeanceCoursRepository seanceCoursRepository;
    private final CoursRepository coursRepository;
    private final ClasseRepository classeRepository;
    private final PointageRepository pointageRepository;
    private final EtudiantRepository etudiantRepository;
    private final AbsenceRepository absenceRepository;



    @PostConstruct
    public void initialiserPointagesDuJour() {
        genererListeDePointagesDuJour();
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void genererListeDePointagesDuJour() {
        LocalDate today = LocalDate.now();
        List<SeanceCours> seancesDuJour = seanceCoursRepository.findByDate(today);
        if (seancesDuJour.isEmpty()) {
            System.out.println("❌ Aucune séance aujourd'hui.");
            return;
        }

        List<Pointage> pointages = new ArrayList<>();

        for (SeanceCours seance : seancesDuJour) {
            Optional<Cours> coursOpt = coursRepository.findById(seance.getCoursId());
            if (coursOpt.isEmpty()) continue;

            Cours cours = coursOpt.get();
            Optional<Classe> classeOpt = classeRepository.findById(cours.getClasseId());
            if (classeOpt.isEmpty()) continue;

            Classe classe = classeOpt.get();
            Duration dureeSeance = Duration.between(seance.getHeureDb(), seance.getHeureFin());
            pointages = remplirPointagesPourEtudiantsDIF(classe, seance, dureeSeance, today, pointages);
            seanceCoursRepository.save(seance);
        }
        System.out.println("✅ " + pointages.size() + " pointages créés pour aujourd’hui (" + today + ")");
    }

    public List<Pointage> remplirPointagesPourEtudiantsDIF(Classe classe, SeanceCours seance, Duration dureeSeance, LocalDate today, List<Pointage> pointages) {

        for (String etudiantId : classe.getEtudiantIds()) {
            Optional<Etudiant> etudiantOpt = etudiantRepository.findById(etudiantId);
            if (etudiantOpt.isEmpty()) continue;
            Etudiant etudiant = etudiantOpt.get();
            if (dureeSeance.toHours() > 2){
                Pointage pointageCoursPlus2h = new Pointage();
                pointageCoursPlus2h = remplissagePointage(pointageCoursPlus2h, seance, today, etudiantId);
                pointages.add(pointageCoursPlus2h);
            }
            Pointage pointage = new Pointage();
            pointage = remplissagePointage(pointage, seance, today, etudiantId);
            pointages.add(pointage);
            seance.getPointageIds().add(pointage.getId());
            etudiant.getPointageIds().add(pointage.getId());
            etudiantRepository.save(etudiant);
        }

        return pointages;
    }

    public Pointage remplissagePointage(Pointage pointage, SeanceCours seance, LocalDate today, String etudiantId){
        pointage.setDate(today);
        pointage.setPointer(Pointer.Abscent);
        pointage.setSeanceCours(seance.getId());
        pointage.setHeureDb(null);
        pointage.setHeureFin(null);

        pointage.setUtilisateur(null);
        pointage.setEtudiant(etudiantId);
        pointage.setHeurePointage(null);
        pointageRepository.save(pointage);
        return pointage;
    }


    @Override
    public List<Pointage> getPointagesBySeance(String seanceId) {
        return pointageRepository.findBySeanceCours(seanceId);
    }

    @Override
    public Pointage save(Pointage pointage) {
        return pointageRepository.save(pointage);
    }

    @Scheduled(cron = "0 * * * * *") // Toutes les minutes
    public void verifierEtGenererAbsences() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        List<SeanceCours> seances = seanceCoursRepository.findByDate(today);
        for (SeanceCours seance : seances) {
            // Une fois 1 minute après HeureFin pour les séances actives
            if (seance.isNow() && now.isAfter(seance.getHeureFin().plusMinutes(1))) {
                for (String pointageId : seance.getPointageIds()) {
                    pointageRepository.findById(pointageId).ifPresent(p -> {
                        if (p.getPointer() == Pointer.Abscent) {
                            Optional<Absence> existingAbs = absenceRepository.findByPointageId(p.getId());
                            if (existingAbs.isEmpty()) {
                                Absence absence = new Absence();
                                absence.setPointageId(p.getId());
                                absence.setJustificationId(null);
                                absenceRepository.save(absence);
                                System.out.println("Absence créée pour pointage : " + p.getId());
                            }
                        }
                    });
                }

                // Désactiver la séance pour éviter recréation multiple
                seance.setNow(false);
                seanceCoursRepository.save(seance);
            }
        }
    }



}
