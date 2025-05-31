package ism.atelier.atelier.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "classe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe extends AbstractEntity {
    private String filiereId;
    private String niveauId;

    private List<String> coursIds = new ArrayList<>();
//    private List<String> coursIds;
    private List<String> etudiantIds = new ArrayList<>();
}
