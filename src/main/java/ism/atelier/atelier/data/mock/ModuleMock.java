package ism.atelier.atelier.data.mock;


import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.data.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Order(4)
@Component
@RequiredArgsConstructor
public class ModuleMock implements CommandLineRunner {
    private final ModuleRepository moduleRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Module> modules = moduleRepository.findAll();
        if (modules.isEmpty()) {
            Module module = new Module();
            module.setId("1");
            module.setName("HTML");
            modules.add(module);

            Module module2 = new Module();
            module2.setId("2");
            module2.setName("ORACLE");
            modules.add(module2);

            Module module3 = new Module();
            module3.setId("3");
            module3.setName("ALGO");
            modules.add(module3);

            Module module4 = new Module();
            module4.setId("4");
            module4.setName("PYTHON");
            modules.add(module4);

            Module module5 = new Module();
            module5.setId("5");
            module5.setName("FLASK");
            modules.add(module5);
        }
        moduleRepository.saveAll(modules);
    }
}
