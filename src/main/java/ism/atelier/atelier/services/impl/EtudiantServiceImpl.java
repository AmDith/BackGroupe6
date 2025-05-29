package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.repository.EtudiantRepository;
import ism.atelier.atelier.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    @Override
    public List<Absence> listerMesAbsences() {
        return List.of();
    }

    @Override
    public void justifierAbsence(Pointage pointage) {

    }

    @Override
    public Etudiant findByMatricule(String matricule) {
        return etudiantRepository.findByMatriculeE(matricule);
    }
}
