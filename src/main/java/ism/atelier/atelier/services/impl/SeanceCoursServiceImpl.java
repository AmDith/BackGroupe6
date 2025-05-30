package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Cours;
import ism.atelier.atelier.data.models.SeanceCours;
import ism.atelier.atelier.data.repository.SeanceCoursRepository;
import ism.atelier.atelier.services.SeanceCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SeanceCoursServiceImpl implements SeanceCoursService {
    private final SeanceCoursRepository seanceCoursRepository;

    @Override
    public SeanceCours getSeanceActuelleDuCours(Cours cours) {
        for (String seanceId : cours.getSeanceCoursIds()) {
            Optional<SeanceCours> seanceOpt = seanceCoursRepository.findById(seanceId);
            if (seanceOpt.isPresent()) {
                SeanceCours seance = seanceOpt.get();
                if (seance.isNow()) {
                    return seance;
                }
            }
        }

        throw new RuntimeException("Aucune séance en cours trouvée pour ce cours.");
    }
}
