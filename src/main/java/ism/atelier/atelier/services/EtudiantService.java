package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.*;
import java.util.List;

public interface EtudiantService {
    List<Absence> listerMesAbsences();
    void justifierAbsence(Pointage pointage);
    Etudiant findByMatricule(String matricule);

}
