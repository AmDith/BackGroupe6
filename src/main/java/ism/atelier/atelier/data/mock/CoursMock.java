package ism.atelier.atelier.data.mock;



import ism.atelier.atelier.data.models.Cours;
import ism.atelier.atelier.data.repository.CoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
//@Order(6)
//@Component
@RequiredArgsConstructor
public class CoursMock implements CommandLineRunner {
    private final CoursRepository coursRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Cours> cours = coursRepository.findAll();
        if (cours.isEmpty()) {
            Cours cours1 = new Cours();
            cours1.setId("1");
            cours1.setNbreHeure(4);
            cours1.setSemestre("semestre 6");     // 8h00
            cours1.setActif(false);   // 12h00
            cours1.getSeanceCoursIds().add("1");
            cours1.setProfesseurId("1");
            cours1.setAnneeScolaireId("1");
            cours1.setClasseId("1");
            cours1.setModuleId("4");
            cours.add(cours1);

            Cours cours2 = new Cours();
            cours2.setId("2");
            cours2.setNbreHeure(2);
            cours2.setSemestre("semestre 6");
            cours2.setActif(false);
            cours2.getSeanceCoursIds().add("3");
            cours2.setProfesseurId("1");
            cours2.setAnneeScolaireId("1");
            cours2.setClasseId("2");
            cours2.setModuleId("2");
            cours.add(cours2);

            Cours cours3 = new Cours();
            cours3.setId("3");
            cours3.setNbreHeure(4);
            cours3.setSemestre("semestre 6");     // 8h00
            cours3.setActif(false);   // 12h00
            cours3.getSeanceCoursIds().add("4");
            cours3.setProfesseurId("1");
            cours3.setAnneeScolaireId("1");
            cours3.setClasseId("1");
            cours3.setModuleId("3");
            cours.add(cours3);

//            Cours cours4 = new Cours();
//            cours4.setId("3");
//            cours4.setNbreHeure(4);
//            cours4.setSemestre("semestre 6");     // 8h00
//            cours4.setActif(false);   // 12h00
//            cours4.getSeanceCoursIds().add("5");
//            cours4.setProfesseurId("1");
//            cours4.setAnneeScolaireId("1");
//            cours4.setClasseId("1");
//            cours4.setModuleId("3");
//            cours.add(cours4);
        }
        coursRepository.saveAll(cours);
    }
}
