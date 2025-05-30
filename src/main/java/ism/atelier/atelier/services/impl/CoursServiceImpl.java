package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Classe;
import ism.atelier.atelier.data.models.Cours;
import ism.atelier.atelier.data.models.SeanceCours;
import ism.atelier.atelier.data.repository.ClasseRepository;
import ism.atelier.atelier.data.repository.CoursRepository;
import ism.atelier.atelier.data.repository.SeanceCoursRepository;
import ism.atelier.atelier.services.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    private final SeanceCoursRepository seanceCoursRepository;
    private final ClasseRepository classeRepository;

    @Scheduled(cron = "0 * * * * *") // chaque minute
    public void surveillerActiviteCours() {
        updateActivationDesCoursParHeureActuelle();
    }

    @Override
    public void updateActivationDesCoursParHeureActuelle() {
        LocalTime heureActuelle = LocalTime.now();

        List<SeanceCours> seancesDuJour = seanceCoursRepository.findByDate(LocalDate.now());

        for (SeanceCours seance : seancesDuJour) {
            Optional<Cours> coursOpt = coursRepository.findById(seance.getCoursId());
            if (coursOpt.isPresent()) {
                Cours cours = coursOpt.get();
                if (!heureActuelle.isBefore(seance.getHeureDb()) && heureActuelle.isBefore(seance.getHeureFin())) {
                    if (!cours.isActif()){
                        cours.setActif(true);
                    }
                    seance.setNow(true);
                } else {
                    LocalTime heureFinAvecDelai = seance.getHeureFin().plusMinutes(5);
                    if (heureActuelle.isAfter(heureFinAvecDelai)) {
                        cours.setActif(false);
                    }
                }
                coursRepository.save(cours);
                seanceCoursRepository.save(seance);
            }
        }
    }

    @Override
    public Cours getCoursActifDeLaClasse(String classeId) {
        Classe classe = classeRepository.findById(classeId)
                .orElseThrow(() -> new RuntimeException("Classe introuvable"));

        return classe.getCoursIds().stream()
                .map(coursRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(Cours::isActif)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun cours actif trouvé pour cette classe."));
    }


}
