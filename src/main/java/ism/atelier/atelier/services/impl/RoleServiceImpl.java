package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Role;
import ism.atelier.atelier.data.repository.RoleRepository;
import ism.atelier.atelier.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role findById(String roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }
}
