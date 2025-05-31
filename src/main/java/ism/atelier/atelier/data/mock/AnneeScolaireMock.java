package ism.atelier.atelier.data.mock;



import ism.atelier.atelier.data.models.AnneeScolaire;
import ism.atelier.atelier.data.repository.AnneeScolaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(10)
@Component
@RequiredArgsConstructor
public class AnneeScolaireMock implements CommandLineRunner {

    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public void run(String... args) throws Exception {
        if (anneeScolaireRepository.count() == 0) {
            AnneeScolaire anneeEnCours = new AnneeScolaire();
            anneeEnCours.setId("1");
            anneeEnCours.setName("2024-2025");

            anneeScolaireRepository.save(anneeEnCours);
        }
    }
}

