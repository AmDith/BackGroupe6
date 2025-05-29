package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JustificationServiceImpl implements JustificationService {
    @Override
    public List<Justification> listerJustification() {
        return List.of();
    }

    @Override
    public Justification valider(Justification justification) {
        return null;
    }
}
