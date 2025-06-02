package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Cours;
import ism.atelier.atelier.data.models.SeanceCours;

public interface SeanceCoursService {
    SeanceCours getSeanceActuelleDuCours(Cours cours);
    SeanceCours findById(String seanceCoursId);
}
