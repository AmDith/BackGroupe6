package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.JustificationRepository;
import ism.atelier.atelier.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JustificationServiceImpl implements JustificationService {
    private final JustificationRepository justificationRepository;
    @Override
    public List<Justification> listerJustification() {
        return List.of();
    }

    @Override
    public Justification valider(String id, String statut) {
        Justification justification = getJustificationById(id);
        if (justification == null) {
            return null;
        }
        try {
            EnumJustification enumJustification = EnumJustification.valueOf(statut);
            justification.setEnumJustification(enumJustification);
            return justificationRepository.save(justification);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Statut invalide");
        }
    }

    @Override
    public Justification getJustificationById(String id) {
        return justificationRepository.findById(id).orElse(null);
    }

    @Override
    public Justification save(Justification justification) {
        return justificationRepository.save(justification);
    }

    @Override
    public List<Justification> findAll() {
        return justificationRepository.findAll();
    }

    @Override
    public Justification findById(String id) {
        return justificationRepository.findById(id).orElse(null);
    }
}
