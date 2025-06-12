package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Role;
import ism.atelier.atelier.data.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.List;

//@Order(1)
//@Component
@RequiredArgsConstructor
public class RoleMock implements CommandLineRunner {
    private final RoleRepository roleRepo;

    @Override
    public void run(String... args) {
        List<Role> roles = roleRepo.findAll();
        if (roles.isEmpty()) {
            Role role1 = new Role();
            role1.setId("1");
            role1.setName("ADMIN");
            roles.add(role1);

            Role role2 = new Role();
            role2.setId("2");
            role2.setName("ETUDIANT");
            roles.add(role2);

            Role role3 = new Role();
            role3.setId("3");
            role3.setName("VIGILE");
            roles.add(role3);
        }
        roleRepo.saveAll(roles);
    }
}
