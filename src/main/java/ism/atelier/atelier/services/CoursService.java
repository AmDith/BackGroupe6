package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Cours;

public interface CoursService {
    void updateActivationDesCoursParHeureActuelle();
    Cours getCoursActifDeLaClasse(String classeId);
    Cours findById(String coursId);
}
