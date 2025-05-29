package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.EnumJustification;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "absence")
@Data

public class Absence {
    @Id
    private String id;
    private LocalDate date;
    private String Cours;
    private String HeureD;
    private String HeureF;
    private EnumJustification etat;
//    private String  justificationId;
//    private String pointageId;
}
