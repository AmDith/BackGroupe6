package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.EnumJustification;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "justifications")
@Data
public class Justification {
    @Id
    private String id;

    private String titre;
    private String motif;
//    private String pieceJointe;

    private String urlPieceJointe;

    @DBRef
    private Absence absence;

    private EnumJustification enumJustification;




//    private String id;
//    private String motifs;
//    private String titre;
//    private String pieceJointe;
//    private String etudiantId;
//    private EnumJustification enumJustification;


//    private LocalDate date;
//    private String nomEtudiant;
//    private String nomModule;
//    private String matricule;
//    private String nomClasse;
//    private String images;
//    private String etatAbsence;
}
