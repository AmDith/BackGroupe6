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
    private List<SeanceCours> seancesDuJour = new ArrayList<>();




    @Scheduled(initialDelay = 10000, fixedDelay = Long.MAX_VALUE)
    public void initialiserPointagesDuJourAvecDelai() {
        genererListeDePointagesDuJour();
    }



    @Scheduled(cron = "0 0 0 * * *")
    public void genererListeDePointagesDuJour() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        seancesDuJour = seanceCoursRepository.findByDate(today);
        System.out.println("seancesDuJour");
        System.out.println(seancesDuJour);
        System.out.println("🧪 Vérif séances du " + today);
        seancesDuJour.forEach(seance -> System.out.println("👉 Séance: " + seance.getId() + " [" + seance.getHeureDb() + " - " + seance.getHeureFin() + "]"));
        if (seancesDuJour.isEmpty()) {
            System.out.println("❌ Aucune séance aujourd'hui.");
            return;
        }

        List<Pointage> pointages = new ArrayList<>();

        for (SeanceCours seance : seancesDuJour) {
            Optional<Cours> coursOpt = coursRepository.findById(seance.getCoursId());
            if (coursOpt.isEmpty()) continue;

            Cours cours = coursOpt.get();
            System.out.println(cours);
            Optional<Classe> classeOpt = classeRepository.findById(cours.getClasseId());
            if (classeOpt.isEmpty()) continue;

            Classe classe = classeOpt.get();
            System.out.println(classe);
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
                seance.getPointageIds().add(pointageCoursPlus2h.getId());
                etudiant.getPointageIds().add(pointageCoursPlus2h.getId());
            }
            Pointage pointage = new Pointage();
            pointage = remplissagePointage(pointage, seance, today, etudiantId);
            pointages.add(pointage);
            seance.getPointageIds().add(pointage.getId());
            etudiant.getPointageIds().add(pointage.getId());
            etudiantRepository.save(etudiant);
            System.out.println(etudiant);
        }

        return pointages;
    }

    public Pointage remplissagePointage(Pointage pointage, SeanceCours seance, LocalDate today, String etudiantId){
        pointage.setDate(today);
        pointage.setPointer(Pointer.Absent);
        pointage.setSeanceCours(seance.getId());
        pointage.setHeureDb(null);
        pointage.setHeureFin(null);

        pointage.setUtilisateur(null);
        pointage.setEtudiant(etudiantId);
        pointage.setHeurePointage(null);
        pointage.setAbsenceId(null);
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

    @Override
    public Pointage getById(String id) {
        return pointageRepository.findById(id).orElse(null);
    }

    @Scheduled(cron = "0 59 15 * * *")
    public void verifierEtGenererAbsences() {
        System.out.println("⏰ Lancement de la génération d'absences à 18h");

        for (SeanceCours seance : seancesDuJour) {
            List<String> pointageIds = seance.getPointageIds();
            if (pointageIds == null || pointageIds.isEmpty()) continue;

            for (String pointageId : pointageIds) {
                pointageRepository.findById(pointageId).ifPresent(p -> {
                    if (p.getPointer() == Pointer.Absent) {
                        Absence absence = new Absence();
                        absence.setPointageId(p.getId());
                        absence.setJustificationId(null);
                        absenceRepository.save(absence);
                        p.setAbsenceId(absence.getId());
                        pointageRepository.save(p);
                        System.out.println("🚨 Absence créée pour pointage : " + p.getId());
                    }
                });
            }
        }

        System.out.println("✅ Fin de génération des absences.");
    }




}
