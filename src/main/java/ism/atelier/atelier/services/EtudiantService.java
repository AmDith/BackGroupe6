package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.mobile.controllers.impl.AbsenceWebDto;

import java.util.List;

public interface EtudiantService {
    List<Absence> listerMesAbsences();
//    List<Pointage> listerMesRetards(Long userConnecteId);
    void justifierAbsence(Pointage pointage);
    List<AbsenceWebDto> getAbsencesEtudiantConnecte();
}
