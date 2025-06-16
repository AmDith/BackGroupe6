package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.JustificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Order(14)
@Component
@RequiredArgsConstructor
public class JustificationMock implements CommandLineRunner {
    private final JustificationRepository justificationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (justificationRepository.count() == 0) {
            List<Justification> justifications = new ArrayList<>();

            // Mock 1 : En cours de traitement
            Justification j1 = new Justification();
            j1.setId("justif001");
            j1.setTitre("Raison médicale");
            j1.setMotif("Hospitalisation courte durée");
            j1.setUrlPieceJointe("/uploads/hospitalisation.pdf");
            j1.setEnumJustification(EnumJustification.ENCOURS);
            j1.setAbsence(null); // à associer plus tard

            // Mock 2 : Déjà validée
            Justification j2 = new Justification();
            j2.setId("justif002");
            j2.setTitre("Consultation médicale");
            j2.setMotif("Consultation chez un spécialiste");
            j2.setUrlPieceJointe("/uploads/consultation_specialiste.pdf");
            j2.setEnumJustification(EnumJustification.VALIDE);
            j2.setAbsence(null);

            // Mock 3 : Refusée
            Justification j3 = new Justification();
            j3.setId("justif003");
            j3.setTitre("Retard de transport");
            j3.setMotif("Panne de bus");
            j3.setUrlPieceJointe("/uploads/incident_bus.pdf");
            j3.setEnumJustification(EnumJustification.REJETER);
            j3.setAbsence(null);

            justifications.add(j1);
            justifications.add(j2);
            justifications.add(j3);

            justificationRepository.saveAll(justifications);
        }
    }
}
