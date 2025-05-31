package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.Mensualite;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "etudiant")
@Data
public class Etudiant extends Personne{
    private String matriculeE;
    private Mensualite mensualite;


    private String classeId;
    private List<String> pointageIds = new ArrayList<>();
}
