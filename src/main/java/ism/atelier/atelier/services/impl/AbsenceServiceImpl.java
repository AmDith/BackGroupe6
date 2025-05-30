package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;

    @Override
    public List<Absence> listerToutPointageAbscent() {
        return List.of();
    }
    @Override
    public Absence save(Absence absence) {
        return absenceRepository.save(absence);
    }
}
