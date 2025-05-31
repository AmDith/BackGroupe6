package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.Pointer;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "pointage")
@Data
public class Pointage {
    @Id
    private String id;
    private LocalDate date;
    private Integer HeureDb;
    private Integer HeureFin;
    private Pointer pointer;

    private String utilisateur;
    private String etudiant;
    private String seanceCours;
}
