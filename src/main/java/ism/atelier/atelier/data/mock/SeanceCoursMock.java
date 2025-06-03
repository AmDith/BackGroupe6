package ism.atelier.atelier.data.mock;


import ism.atelier.atelier.data.models.SeanceCours;
import ism.atelier.atelier.data.repository.SeanceCoursRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Order(11)
@Component
@RequiredArgsConstructor
public class SeanceCoursMock implements CommandLineRunner {
    private final SeanceCoursRepository seanceCoursRepository;
    @Override
    public void run(String... args) throws Exception {
        List<SeanceCours> seanceCours = seanceCoursRepository.findAll();
        if (seanceCours.isEmpty()) {
            SeanceCours seanceCours1 = new SeanceCours();
            seanceCours1.setId("1");
            seanceCours1.setDate(LocalDate.parse("2025-06-03"));
            seanceCours1.setHeureDb(LocalTime.of(8, 5));     // 8h00
            seanceCours1.setHeureFin(LocalTime.of(8, 25));   // 12h00
            seanceCours1.setNow(false);
            seanceCours1.setCoursId("1");
//            seanceCours1.getPointageIds().add("1");
//            seanceCours1.getPointageIds().add("2");
            seanceCours.add(seanceCours1);

//            SeanceCours seanceCours2 = new SeanceCours();
//            seanceCours2.setId("2");
//            seanceCours2.setDate(LocalDate.parse("2025-06-02"));
//            seanceCours2.setHeureDb(LocalTime.of(16, 27));
//            seanceCours2.setHeureFin(LocalTime.of(16, 57));
//            seanceCours2.setNow(false);
//            seanceCours2.setCoursId("1");
////            seanceCours2.getPointageIds().add("3");
//            seanceCours.add(seanceCours2);


        }
        seanceCoursRepository.saveAll(seanceCours);
    }
}