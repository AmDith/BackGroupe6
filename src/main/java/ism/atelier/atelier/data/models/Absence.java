package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.EnumJustification;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "absence")
@Data

public class Absence {
    @Id
    private String id;
//    private String  justificationId;
//    private String pointageId;

    private String matiere;
    private String date;
    private String etat; // NON-JUSTIFIE, EN_ATTENTE, JUSTIFIE
    private String horaire;

    @DBRef
    private Justification justification;

    @DBRef
    private Etudiant etudiant;

    @DBRef
    private Cours cours;




//    private LocalDate date;
//    private String nomModule;
//    private String nomEtudiant;
//    private String etat;
//    private String nomClasse;

//    private String id;
//    private String  justificationId;
//    private String pointageId;
//    private String statut;

//    private String  justificationId;
//    private String pointageId;
}
