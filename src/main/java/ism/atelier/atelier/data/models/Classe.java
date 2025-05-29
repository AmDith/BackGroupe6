package ism.atelier.atelier.data.models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "classe")
@Data
public class Classe extends AbstractEntity {
    private String filiereId;
    private String niveauId;

    private List<String> coursIds;
    private List<String> etudiantIds;
}
