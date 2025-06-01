package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.Pointer;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "pointage")
@Data
public class Pointage {
    @Id
    private String id;
    private LocalDate date;
    private LocalTime heurePointage;
    private LocalTime HeureDb;
    private LocalTime HeureFin;
    private Pointer pointer;
    private String absenceId;


    private String utilisateur;
    private String etudiant;
    private String seanceCours;
}
