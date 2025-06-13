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
            seanceCours1.setDate(LocalDate.parse("2025-06-13"));
            seanceCours1.setHeureDb(LocalTime.of(14, 56));
            seanceCours1.setHeureFin(LocalTime.of(15, 30));
            seanceCours1.setNow(false);
            seanceCours1.setCoursId("1");
            seanceCours.add(seanceCours1);

            SeanceCours seanceCours2 = new SeanceCours();
            seanceCours2.setId("2");
            seanceCours2.setDate(LocalDate.parse("2025-06-13"));
            seanceCours2.setHeureDb(LocalTime.of(14, 56));
            seanceCours2.setHeureFin(LocalTime.of(15, 30));
            seanceCours2.setNow(false);
            seanceCours2.setCoursId("1");
            seanceCours.add(seanceCours2);


            SeanceCours seanceCours3 = new SeanceCours();
            seanceCours3.setId("3");
            seanceCours3.setDate(LocalDate.parse("2025-06-13"));
            seanceCours3.setHeureDb(LocalTime.of(14, 56));
            seanceCours3.setHeureFin(LocalTime.of(15, 20));
            seanceCours3.setNow(false);
            seanceCours3.setCoursId("2");
            seanceCours.add(seanceCours3);

            SeanceCours seanceCours4 = new SeanceCours();
            seanceCours4.setId("4");
            seanceCours4.setDate(LocalDate.parse("2025-06-13"));
            seanceCours4.setHeureDb(LocalTime.of(14, 56));
            seanceCours4.setHeureFin(LocalTime.of(15, 20));
            seanceCours4.setNow(false);
            seanceCours4.setCoursId("3");
            seanceCours.add(seanceCours4);


        }
        seanceCoursRepository.saveAll(seanceCours);
    }
}