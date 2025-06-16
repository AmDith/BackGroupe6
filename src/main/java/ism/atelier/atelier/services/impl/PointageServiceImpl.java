package ism.atelier.atelier.services.impl;


import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.repository.PointageRepository;
import ism.atelier.atelier.services.PointageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointageServiceImpl implements PointageService {
    private final PointageRepository pointageRepository;
    @Override
    public void pointerEtudiant(Etudiant etudiant, Long utilisateurId) {

    }

    @Override
    public Pointage getById(String pointageId) {
        return pointageRepository.findById(pointageId).orElseThrow();
    }
}
