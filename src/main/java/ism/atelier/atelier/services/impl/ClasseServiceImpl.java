package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Classe;
import ism.atelier.atelier.data.repository.ClasseRepository;
import ism.atelier.atelier.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;

    @Override
    public Classe getClasse(String classeId) {
        return classeRepository.findById(classeId)
                .orElse(null);
    }
}
