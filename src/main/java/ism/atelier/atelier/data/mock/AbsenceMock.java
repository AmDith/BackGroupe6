package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.data.repository.JustificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Order(13)
@Component
@RequiredArgsConstructor
public class AbsenceMock implements CommandLineRunner {
    private final AbsenceRepository absenceRepository;
    private final JustificationRepository justificationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (absenceRepository.count() == 0) {
            List<Justification> justifications = justificationRepository.findAll();

                if (!justifications.isEmpty()) {
                    List<Absence> absences = new ArrayList<>();

                    // Absence liée à une justification
                    Absence absence1 = new Absence();
                    absence1.setId("absence456");
                    absence1.setMatiere("Java Avancé");
                    absence1.setDate("2024-11-05");
                    absence1.setEtat("EN_ATTENTE");
                    absence1.setHoraire("14H-18H");
                    absence1.setJustification(justifications.get(0)); // association directe

                    Absence absence2 = new Absence();
                    absence1.setId("absence457");
                    absence1.setMatiere("Spring");
                    absence1.setDate("2024-11-05");
                    absence1.setEtat("VALIDE");
                    absence1.setHoraire("14H-18H");
                    absence1.setJustification(justifications.get(0));

                    // Absence sans justification
                    Absence absence3 = new Absence();
                    absence2.setId("absence001");
                    absence2.setMatiere("UX-UI DESIGN");
                    absence2.setDate("2024-10-20");
                    absence2.setEtat("NON-JUSTIFIE");
                    absence2.setHoraire("8H-12H");
                    absence2.setJustification(null); // aucune justification encore

                    Absence absence4 = new Absence();
                    absence2.setId("absence002");
                    absence2.setMatiere("Design Pattern");
                    absence2.setDate("2024-10-20");
                    absence2.setEtat("JUSTIFIE");
                    absence2.setHoraire("8H-12H");
                    absence2.setJustification(null); // aucune justification encore

                    absences.add(absence1);
                    absences.add(absence2);
                    absences.add(absence3);
                    absences.add(absence4);

                    absenceRepository.saveAll(absences);
                }
            }
    }
}
