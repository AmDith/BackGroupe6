package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;

import java.util.List;

public interface JustificationService {
//    List<Justification> listerJustification();
    Justification valider(String id, String statut);
    Justification ajouterJustification(JustificationAbsentDto justificationDto);
    Justification getJustificationById(String id);
    Justification getJustificationsByEtudiant(String etudiantId);
    List<Justification> getAllJustifications();
    void supprimerJustification(String id);
    Justification save(Justification justification);
}
