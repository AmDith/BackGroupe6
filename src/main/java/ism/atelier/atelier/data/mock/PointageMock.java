package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.repository.PointageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Order(12)
@Component
@RequiredArgsConstructor
public class PointageMock implements CommandLineRunner {
    private final PointageRepository pointageRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Pointage> pointages = pointageRepository.findAll();
        if (pointages.isEmpty()) {
            Pointage pointage1 = new Pointage();
            pointage1.setId("1");
            pointage1.setDate(LocalDate.parse("2025-06-01"));
            pointage1.setHeurePointage(null);
            pointage1.setHeureDb(LocalTime.of(8, 0));     // 8h00
            pointage1.setHeureFin(LocalTime.of(8, 30));   // 12h00
            pointage1.setPointer(Pointer.Abscent);
            pointage1.setUtilisateur("2");
            pointage1.setEtudiant("3");
            pointage1.setSeanceCours("1");
            pointage1.setAbsenceId(null);
            pointages.add(pointage1);

            Pointage pointage2 = new Pointage();
            pointage2.setId("2");
            pointage2.setDate(LocalDate.parse("2025-06-01"));
            pointage2.setHeurePointage(null);
            pointage2.setHeureDb(LocalTime.of(11, 30));     // 8h00
            pointage2.setHeureFin(LocalTime.of(12, 0));   // 10h00
            pointage2.setPointer(Pointer.Abscent);
            pointage2.setUtilisateur("2");
            pointage2.setEtudiant("3");
            pointage2.setSeanceCours("1");
            pointage2.setAbsenceId("2");
            pointages.add(pointage2);

            Pointage pointage3 = new Pointage();
            pointage3.setId("3");
            pointage3.setDate(LocalDate.parse("2025-06-01"));
            pointage3.setHeurePointage(null);
            pointage3.setHeureDb(LocalTime.of(13, 0));     // 8h00
            pointage3.setHeureFin(LocalTime.of(13, 30));   // 12h00
            pointage3.setPointer(Pointer.Abscent);
            pointage3.setUtilisateur("1");
            pointage3.setEtudiant("4");
            pointage3.setSeanceCours("2");
            pointage3.setAbsenceId("1");
            pointages.add(pointage3);
        }
        pointageRepository.saveAll(pointages);
    }
}
