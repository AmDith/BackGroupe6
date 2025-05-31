package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Filiere;
import ism.atelier.atelier.data.repository.FiliereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(3)
@Component
@RequiredArgsConstructor
public class FiliereMock implements CommandLineRunner {

    private final FiliereRepository filiereRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Filiere> filieres = filiereRepository.findAll();
        if (filieres.isEmpty()) {
            Filiere filiere = new Filiere();
            filiere.setId("1");
            filiere.setName("GLRS");
            filieres.add(filiere);

            Filiere filiere2 = new Filiere();
            filiere2.setId("2");
            filiere2.setName("CDSD");
            filieres.add(filiere2);

            Filiere filiere3 = new Filiere();
            filiere3.setId("3");
            filiere3.setName("ETSE");
            filieres.add(filiere3);

            Filiere filiere4 = new Filiere();
            filiere4.setId("4");
            filiere4.setName("TTL");
            filieres.add(filiere4);

            Filiere filiere5 = new Filiere();
            filiere5.setId("5");
            filiere5.setName("IAGE");
            filieres.add(filiere5);
        }
        filiereRepository.saveAll(filieres);
    }
}
