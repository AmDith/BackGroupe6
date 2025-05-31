package ism.atelier.atelier.data.mock;


import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.data.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Order(9)
@Component
@RequiredArgsConstructor
public class UtilisateurMock implements CommandLineRunner {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public void run(String... args) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        if (utilisateurs.isEmpty()){
            Utilisateur vigile = new Utilisateur();
            vigile.setId("1");
            vigile.setNomComple("Tidiane Ba");
            vigile.setTel("+221770000000");
            vigile.setLogin("tidiane.ba");
            vigile.setPassword("123456");
            vigile.setRoleId("3");
            vigile.setEtudiantId(null);
            vigile.setProfesseurId(null);
            vigile.getPointageIds().add("1");
            vigile.getPointageIds().add("3");
            utilisateurs.add(vigile);

            Utilisateur prof2 = new Utilisateur();
            prof2.setId("2");
            prof2.setNomComple("Aminata Diop");
            prof2.setTel("+221780000001");
            prof2.setLogin("amina.diop");
            prof2.setPassword("profpass");
            prof2.setRoleId("3");
            prof2.setEtudiantId(null);
            prof2.setProfesseurId("1");
            prof2.getPointageIds().add("2");
            utilisateurs.add(prof2);

            Utilisateur prof1 = new Utilisateur();
            prof1.setId("3");
            prof1.setNomComple("Ousmane Dia");
            prof1.setTel("+221780000002");
            prof1.setLogin("ousmane.dia");
            prof1.setPassword("profpass");
            prof1.setRoleId("3");
            prof1.setEtudiantId(null);
            prof1.setProfesseurId("2");
            prof1.getPointageIds().add(null);
            utilisateurs.add(prof1);

            Utilisateur et1 = new Utilisateur();
            et1.setId("4");
            et1.setNomComple("Tina Ba");
            et1.setTel("+221780000003");
            et1.setLogin("tina.ba");
            et1.setPassword("etupass");
            et1.setRoleId("2");
            et1.setEtudiantId("1");
            et1.setProfesseurId(null);
            et1.getPointageIds().add(null);
            utilisateurs.add(et1);

            Utilisateur et2 = new Utilisateur();
            et2.setId("5");
            et2.setNomComple("Henry Tall");
            et2.setTel("+221780000004");
            et2.setLogin("henry.tall");
            et2.setPassword("etupass");
            et2.setRoleId("2");
            et2.setEtudiantId("2");
            et2.setProfesseurId(null);
            et2.getPointageIds().add(null);
            utilisateurs.add(et2);

            Utilisateur et3 = new Utilisateur();
            et3.setId("6");
            et3.setNomComple("François Du Mbote");
            et3.setTel("+221780000005");
            et3.setLogin("françois.du.mbote");
            et3.setPassword("etupass");
            et3.setRoleId("2");
            et3.setEtudiantId("3");
            et3.setProfesseurId(null);
            et3.getPointageIds().add(null);
            utilisateurs.add(et3);

            Utilisateur et4 = new Utilisateur();
            et4.setId("7");
            et4.setNomComple("Silverstar");
            et4.setTel("+221780000006");
            et4.setLogin("silverstar");
            et4.setPassword("etupass");
            et4.setRoleId("2");
            et4.setEtudiantId("4");
            et4.setProfesseurId(null);
            et4.getPointageIds().add(null);
            utilisateurs.add(et4);

            Utilisateur et5 = new Utilisateur();
            et5.setId("8");
            et5.setNomComple("Dith Dith");
            et5.setTel("+221780000007");
            et5.setLogin("dith.dith");
            et5.setPassword("etupass");
            et5.setRoleId("2");
            et5.setEtudiantId("5");
            et5.setProfesseurId(null);
            et5.getPointageIds().add(null);
            utilisateurs.add(et5);

            Utilisateur admin = new Utilisateur();
            admin.setId("7");
            admin.setNomComple("Amour");
            admin.setTel("+221780000008");
            admin.setLogin("amour");
            admin.setPassword("adminpass");
            admin.setRoleId("1");
            admin.setEtudiantId(null);
            admin.setProfesseurId(null);
            admin.getPointageIds().add(null);
            utilisateurs.add(admin);

        }
        utilisateurRepository.saveAll(utilisateurs);
    }
}
