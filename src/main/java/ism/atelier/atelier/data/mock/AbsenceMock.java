package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.data.repository.JustificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

                Absence a1 = new Absence();
                a1.setPointageId("pointage-001");
                a1.setJustificationId(justifications.get(0).getId());

                Absence a2 = new Absence();
                a2.setPointageId("pointage-002");
                a2.setJustificationId(justifications.get(1).getId());

                absences.add(a1);
                absences.add(a2);

                absenceRepository.saveAll(absences);
            }
        }
    }
}
