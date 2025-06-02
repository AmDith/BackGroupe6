package ism.atelier.atelier.data.mock;


import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.SeanceCours;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.data.repository.SeanceCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Order(13)
@Component
@RequiredArgsConstructor
public class AbsenceMock implements CommandLineRunner {
    private final AbsenceRepository absenceRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Absence> absences = absenceRepository.findAll();
        if (absences.isEmpty()) {
            Absence absence = new Absence();
            absence.setId("1");
            absence.setJustificationId(null);
            absence.setPointageId("3");
            absences.add(absence);

            Absence absence2 = new Absence();
            absence2.setId("2");
            absence2.setJustificationId(null);
            absence2.setPointageId("2");
            absences.add(absence2);

        }
        absenceRepository.saveAll(absences);
    }
}