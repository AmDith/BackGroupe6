package ism.atelier.atelier.data.mock;




import ism.atelier.atelier.data.models.Classe;
import ism.atelier.atelier.data.repository.ClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Order(7)
@Component
@RequiredArgsConstructor
public class ClasseMock implements CommandLineRunner {
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Classe> classes = classeRepository.findAll();
        if (classes.isEmpty()) {
            Classe classe1 = new Classe();
            classe1.setId("1");
            classe1.setName("L3GLRS");
            classe1.setFiliereId("1");
            classe1.setNiveauId("3");
            classe1.getCoursIds().add("1");
            classe1.getEtudiantIds().add("1");
            classe1.getEtudiantIds().add("2");
            classe1.getEtudiantIds().add("3");
            classes.add(classe1);

            Classe classe2 = new Classe();
            classe2.setId("2");
            classe2.setName("L3CDSD");
            classe2.setFiliereId("2");     // 8h00
            classe2.setNiveauId("3");   // 12h00
            classe2.getCoursIds().add("2");
            classe2.getEtudiantIds().add("4");
            classe2.getEtudiantIds().add("5");
            classes.add(classe2);
        }
        classeRepository.saveAll(classes);
    }
}
