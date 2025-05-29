package ism.atelier.atelier.data.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "cours")
@Data
public class Cours {
    @Id
    private String id;
    private Integer nbreHeure;
    private String semestre;
    private boolean actif;

    private List<String> seanceCoursIds = new ArrayList<>();
    private String professeurId;
    private String anneeScolaireId;
    private String classeId;
    private String moduleId;
}
