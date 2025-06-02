package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.models.Utilisateur;

import java.util.List;

public interface JustificationService {
    List<Justification> listerJustification();
    Justification valider(String id, String statut);
    Justification getJustificationById(String id);
    Justification save(Justification justification);
    List<Justification> findAll();
    Justification findById(String id);
}
