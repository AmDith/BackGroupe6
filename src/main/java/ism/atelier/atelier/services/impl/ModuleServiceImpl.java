package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.data.repository.ModuleRepository;
import ism.atelier.atelier.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    @Override
    public Module findById(String moduleId) {
        return moduleRepository.findById(moduleId).orElse(null);
    }
}
