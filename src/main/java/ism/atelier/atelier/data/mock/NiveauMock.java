package ism.atelier.atelier.data.mock;


import ism.atelier.atelier.data.models.Niveau;
import ism.atelier.atelier.data.repository.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
//@Order(2)
//@Component
@RequiredArgsConstructor
public class NiveauMock implements CommandLineRunner {
    private final NiveauRepository niveauRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Niveau> niveaux = niveauRepository.findAll();
        if (niveaux.isEmpty()) {
            Niveau niveau = new Niveau();
            niveau.setId("1");
            niveau.setName("L1");
            niveaux.add(niveau);

            Niveau niveau2 = new Niveau();
            niveau2.setId("2");
            niveau2.setName("L2");
            niveaux.add(niveau2);

            Niveau niveau3 = new Niveau();
            niveau3.setId("3");
            niveau3.setName("L3");
            niveaux.add(niveau3);

            Niveau niveau4 = new Niveau();
            niveau4.setId("4");
            niveau4.setName("M1");
            niveaux.add(niveau4);

            Niveau niveau5 = new Niveau();
            niveau5.setId("5");
            niveau5.setName("M2");
            niveaux.add(niveau5);
        }
        niveauRepository.saveAll(niveaux);
    }
}
