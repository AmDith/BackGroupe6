package ism.atelier.atelier.services.impl;


import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.services.PointageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointageServiceImpl implements PointageService {
    @Override
    public Pointage pointerEtudiant(Etudiant etudiant) {
        return null;
    }
}
