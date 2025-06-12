package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.enums.Mensualite;
import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
//@Order(8)
//@Component
@RequiredArgsConstructor
public class EtudiantMock implements CommandLineRunner {
    private final EtudiantRepository etudiantRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        if (etudiants.isEmpty()) {
            Etudiant et1 = new Etudiant();
            et1.setId("1");
            et1.setNomComple("Tina Ba");
            et1.setMatriculeE("ISM333444");
            et1.setMensualite(Mensualite.AJOUR);
            et1.setClasseId("1");
//            et1.getPointageIds().add(null);
            etudiants.add(et1);

            Etudiant et2 = new Etudiant();
            et2.setId("2");
            et2.setNomComple("Henry Tall");
            et2.setMatriculeE("ISM333445");
            et2.setMensualite(Mensualite.PASAJOUR);
            et2.setClasseId("1");
//            et2.getPointageIds().add(null);
            etudiants.add(et2);

            Etudiant et3 = new Etudiant();
            et3.setId("3");
            et3.setNomComple("François Du Mbote");
            et3.setMatriculeE("ISM333446");
            et3.setMensualite(Mensualite.AJOUR);
            et3.setClasseId("1");
//            et3.getPointageIds().add("1");
//            et3.getPointageIds().add("2");
            etudiants.add(et3);

            Etudiant et4 = new Etudiant();
            et4.setId("4");
            et4.setNomComple("Silverstar");
            et4.setMatriculeE("ISM333447");
            et4.setMensualite(Mensualite.AJOUR);
            et4.setClasseId("2");
//            et4.getPointageIds().add(null);
            etudiants.add(et4);

            Etudiant et5 = new Etudiant();
            et5.setId("5");
            et5.setNomComple("Dith Dith");
            et5.setMatriculeE("ISM333448");
            et5.setMensualite(Mensualite.PASAJOUR);
            et5.setClasseId("2");
//            et5.getPointageIds().add("3");
            etudiants.add(et5);
        }
        etudiantRepository.saveAll(etudiants);
    }
}
