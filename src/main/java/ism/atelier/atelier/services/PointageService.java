package ism.atelier.atelier.services;

import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.models.Pointage;

import java.util.List;

public interface PointageService {
    void pointerEtudiant(Etudiant etudiant, Long utilisateurId);
}
