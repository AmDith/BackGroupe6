package ism.atelier.atelier.data.mock;

import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.data.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(9)
@Component
@RequiredArgsConstructor
public class UtilisateurMock implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder; // Injecté automatiquement grâce à ton SecurityConfig

    @Override
    public void run(String... args) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        if (utilisateurs.isEmpty()) {
            utilisateurs = new ArrayList<>();

            Utilisateur vigile = new Utilisateur();
            vigile.setId("1");
            vigile.setNomComple("Tidiane Ba");
            vigile.setTel("+221770000000");
            vigile.setLogin("tidiane.ba");
            vigile.setPassword(passwordEncoder.encode("123456")); // encodé ici
            vigile.setRoleId("3");
            vigile.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749734018/avatars-vCyCUJLVDx3zp3L9-fHpBaQ-t240x240_r7nuxr.jpg");
            utilisateurs.add(vigile);

            Utilisateur prof2 = new Utilisateur();
            prof2.setId("2");
            prof2.setNomComple("Aminata Diop");
            prof2.setTel("+221780000001");
            prof2.setLogin("amina.diop");
            prof2.setPassword(passwordEncoder.encode("profpass"));
            prof2.setRoleId("3");
            prof2.setProfesseurId("1");
            prof2.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749734018/avatars-vCyCUJLVDx3zp3L9-fHpBaQ-t240x240_r7nuxr.jpg");
            utilisateurs.add(prof2);

            Utilisateur prof1 = new Utilisateur();
            prof1.setId("3");
            prof1.setNomComple("Ousmane Dia");
            prof1.setTel("+221780000002");
            prof1.setLogin("ousmane.dia");
            prof1.setPassword(passwordEncoder.encode("profpass"));
            prof1.setRoleId("3");
            prof1.setProfesseurId("2");
            prof1.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749734018/avatars-vCyCUJLVDx3zp3L9-fHpBaQ-t240x240_r7nuxr.jpg");
            utilisateurs.add(prof1);

            Utilisateur et1 = new Utilisateur();
            et1.setId("4");
            et1.setNomComple("Tina Ba");
            et1.setTel("+221780000003");
            et1.setLogin("tina.ba");
            et1.setPassword(passwordEncoder.encode("etupass"));
            et1.setRoleId("2");
            et1.setEtudiantId("1");
            et1.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749732993/la-senegalaise-sira-fall-fait-partie-des-plus-de-200-etudiants-etrangers-inscrits-a-l-iut-de-longwy-photo-dr-1639232338_trvdjw.jpg");
            utilisateurs.add(et1);

            Utilisateur et2 = new Utilisateur();
            et2.setId("5");
            et2.setNomComple("Henry Tall");
            et2.setTel("+221780000004");
            et2.setLogin("henry.tall");
            et2.setPassword(passwordEncoder.encode("etupass"));
            et2.setRoleId("2");
            et2.setEtudiantId("2");
            et2.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1748928790/samples/man-portrait.jpg");
            utilisateurs.add(et2);

            Utilisateur et3 = new Utilisateur();
            et3.setId("6");
            et3.setNomComple("François Du Mbote");
            et3.setTel("+221780000005");
            et3.setLogin("françois.du.mbote");
            et3.setPassword(passwordEncoder.encode("etupass"));
            et3.setRoleId("2");
            et3.setEtudiantId("3");
            et3.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749733311/img-20170321-wa0008_hgoq3d.jpg");
            utilisateurs.add(et3);

            Utilisateur et4 = new Utilisateur();
            et4.setId("7");
            et4.setNomComple("Silverstar");
            et4.setTel("+221780000006");
            et4.setLogin("silverstar");
            et4.setPassword(passwordEncoder.encode("etupass"));
            et4.setRoleId("2");
            et4.setEtudiantId("4");
            et4.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749733453/1000_F_219025521_A31RZn4KaZiieuTnuQoj1kan4FyuZKga_uqx5dk.jpg");
            utilisateurs.add(et4);

            Utilisateur et5 = new Utilisateur();
            et5.setId("8");
            et5.setNomComple("Dith Dith");
            et5.setTel("+221780000007");
            et5.setLogin("dith.dith");
            et5.setPassword(passwordEncoder.encode("etupass"));
            et5.setRoleId("2");
            et5.setEtudiantId("5");
            et5.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749733582/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f6471566a55613172306f2d4c45673d3d2d3532333330353532332e313530616130396333386362336136303235373437393530313733392e6a7067_azipoq.jpg");
            utilisateurs.add(et5);

            Utilisateur admin = new Utilisateur();
            admin.setId("9");
            admin.setNomComple("KANE DIABY");
            admin.setTel("+221780000008");
            admin.setLogin("KANE DIABY");
            admin.setPassword(passwordEncoder.encode("adminpass"));
            admin.setRoleId("1");
            admin.setImage("https://res.cloudinary.com/dgbz1s1wj/image/upload/v1749734018/avatars-vCyCUJLVDx3zp3L9-fHpBaQ-t240x240_r7nuxr.jpg");
            utilisateurs.add(admin);

            utilisateurRepository.saveAll(utilisateurs);
        }
    }
}
