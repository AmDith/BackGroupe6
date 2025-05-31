package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.JustificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JustificationMock implements CommandLineRunner {
    private final JustificationRepository justificationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (justificationRepository.count() == 0) {
            List<Justification> justifications = new ArrayList<>();

            Justification j1 = new Justification();
            j1.setTitre("Maladie");
            j1.setMotifs("Fièvre et toux sévère");
            j1.setPieceJointe("maladie.pdf");

            Justification j2 = new Justification();
            j2.setTitre("Rendez-vous médical");
            j2.setMotifs("Consultation chez le dentiste");
            j2.setPieceJointe("rdv_dentiste.jpg");

            justifications.add(j1);
            justifications.add(j2);

            justificationRepository.saveAll(justifications);
        }
    }
}
