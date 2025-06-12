package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.enums.Mensualite;
import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Order(8)
@Component
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
            et1.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749732993/la-senegalaise-sira-fall-fait-partie-des-plus-de-200-etudiants-etrangers-inscrits-a-l-iut-de-longwy-photo-dr-1639232338_trvdjw.jpg");
            et1.setMensualite(Mensualite.AJOUR);
            et1.setClasseId("1");
//            et1.getPointageIds().add(null);
            etudiants.add(et1);

            Etudiant et2 = new Etudiant();
            et2.setId("2");
            et2.setNomComple("Henry Tall");
            et2.setMatriculeE("ISM333445");
            et2.setMensualite(Mensualite.PASAJOUR);
            et2.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1748928790/samples/man-portrait.jpg");
            et2.setClasseId("1");
//            et2.getPointageIds().add(null);
            etudiants.add(et2);

            Etudiant et3 = new Etudiant();
            et3.setId("3");
            et3.setNomComple("François Du Mbote");
            et3.setMatriculeE("ISM333446");
            et3.setMensualite(Mensualite.AJOUR);
            et3.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749733311/img-20170321-wa0008_hgoq3d.jpg");
            et3.setClasseId("1");
//            et3.getPointageIds().add("1");
//            et3.getPointageIds().add("2");
            etudiants.add(et3);

            Etudiant et4 = new Etudiant();
            et4.setId("4");
            et4.setNomComple("Silverstar");
            et4.setMatriculeE("ISM333447");
            et4.setMensualite(Mensualite.AJOUR);
            et4.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749733453/1000_F_219025521_A31RZn4KaZiieuTnuQoj1kan4FyuZKga_uqx5dk.jpg");
            et4.setClasseId("2");
            et4.setImage("");
//            et4.getPointageIds().add(null);
            etudiants.add(et4);

            Etudiant et5 = new Etudiant();
            et5.setId("5");
            et5.setNomComple("Dith Dith");
            et5.setMatriculeE("ISM333448");
            et5.setMensualite(Mensualite.PASAJOUR);
            et5.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749733582/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f6471566a55613172306f2d4c45673d3d2d3532333330353532332e313530616130396333386362336136303235373437393530313733392e6a7067_azipoq.jpg");
            et5.setClasseId("2");
//            et5.getPointageIds().add("3");
            etudiants.add(et5);
        }
        etudiantRepository.saveAll(etudiants);
    }
}
