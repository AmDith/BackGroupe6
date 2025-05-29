package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.models.Utilisateur;

import java.util.List;

public interface JustificationService {
    List<Justification> listerJustification();
    Justification valider(Justification justification);
}
