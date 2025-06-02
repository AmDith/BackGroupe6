package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Absence findById(String AbsenceId) {
        return absenceRepository.findById(AbsenceId).orElse(null);
    }

    @Override
    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    @Override
    public List<Absence> getAllAsenceJustifier() {
        return absenceRepository.findAll().stream()
                .filter(absence -> absence.getJustificationId() != null)
                .collect(Collectors.toList());
    }

    @Override
    public Absence getAbsence(String id) {
        return absenceRepository.findById(id).orElse(null);
    }
}
