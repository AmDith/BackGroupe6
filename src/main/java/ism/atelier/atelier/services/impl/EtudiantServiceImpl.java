package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor


public class EtudiantServiceImpl implements EtudiantService {
    @Override
    public List<Absence> listerMesAbsences() {
        return List.of();
    }

    @Override
    public void justifierAbsence(Pointage pointage) {

    }
}
