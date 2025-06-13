package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Professeur;
import ism.atelier.atelier.data.repository.CoursRepository;
import ism.atelier.atelier.data.repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
//@Order(5)
//@Component
@RequiredArgsConstructor
public class ProfesseurMock implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;
    private final CoursRepository coursRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Professeur> professeurs = professeurRepository.findAll();
        if (professeurs.isEmpty()) {
            Professeur prof2 = new Professeur();
            prof2.setId("1");
            prof2.setNomComple("Aminata Diop");
            prof2.setSpecialite("DevFullStack");
            prof2.setGrade("expert");
            prof2.getCoursIds().add("1");
            professeurs.add(prof2);

            Professeur prof1 = new Professeur();
            prof1.setId("2");
            prof1.setNomComple("Ousmane Dia");
            prof1.setSpecialite("SYSDBA");
            prof1.setGrade("expert");
            prof1.getCoursIds().add("2");
            professeurs.add(prof1);
        }
        professeurRepository.saveAll(professeurs);
    }
}
