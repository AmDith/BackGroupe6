package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AbsenceServiceImpl implements AbsenceService {
    @Override
    public List<Absence> listerToutPointageAbscent() {
        return List.of();
    }
}
