package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;

import java.util.List;

public interface JustificationService {
//    List<Justification> listerJustification();
//    Justification valider(String id, String statut);
    Justification ajouterJustification(JustificationAbsentDto justificationDto);
    Justification getJustificationById(Long id);
    List<Justification> getJustificationsByEtudiant(Long etudiantId);
    List<Justification> getAllJustifications();
    void supprimerJustification(Long id);
}
