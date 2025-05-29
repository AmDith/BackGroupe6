package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Cours;
import ism.atelier.atelier.data.models.SeanceCours;
import ism.atelier.atelier.data.repository.CoursRepository;
import ism.atelier.atelier.data.repository.SeanceCoursRepository;
import ism.atelier.atelier.services.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    private final SeanceCoursRepository seanceCoursRepository;

    @Scheduled(cron = "0 * * * * *") // chaque minute
    public void surveillerActiviteCours() {
        updateActivationDesCoursParHeureActuelle();
    }

    @Override
    public void updateActivationDesCoursParHeureActuelle() {
        LocalTime heureActuelle = LocalTime.now();

        List<SeanceCours> seancesDuJour = seanceCoursRepository.findByDate(LocalDate.now());

        for (SeanceCours seance : seancesDuJour) {
            Cours cours = coursRepository.findById(seance.getCours());
            if (heureActuelle.equals(seance.getHeureDb())) {
                cours.setActif(true);
            } else if (heureActuelle.isAfter(seance.getHeureFin())) {
                cours.setActif(false);
            }

            coursRepository.save(cours);
        }
    }
    }
}
