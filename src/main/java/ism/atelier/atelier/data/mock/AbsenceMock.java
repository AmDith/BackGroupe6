package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(13)
@Component
@RequiredArgsConstructor
public class AbsenceMock implements CommandLineRunner {

    private final AbsenceRepository absenceRepository;

    @Override
    public void run(String... args) throws Exception {
        if (absenceRepository.findAll().isEmpty()) {
            List<Absence> absences = new ArrayList<>();

            Absence absence1 = new Absence();
            absence1.setJustificationId("justif-1");
            absence1.setPointageId("1");

            Absence absence2 = new Absence();
            absence2.setJustificationId("justif-2");
            absence2.setPointageId("2");

            Absence absence3 = new Absence();
            absence3.setJustificationId("justif-3");
            absence3.setPointageId("3");

            absences.add(absence1);
            absences.add(absence2);
            absences.add(absence3);

            absenceRepository.saveAll(absences);
            System.out.println("✅ Absences mock insérées avec succès !");
        }
    }
}

