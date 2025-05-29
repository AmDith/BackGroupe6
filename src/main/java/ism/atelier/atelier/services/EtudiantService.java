package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.*;
import java.util.List;

public interface EtudiantService {
    List<Absence> listerMesAbsences();
//    List<Pointage> listerMesRetards(Long userConnecteId);
    void justifierAbsence(Pointage pointage);
}
