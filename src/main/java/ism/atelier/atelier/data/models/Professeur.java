package ism.atelier.atelier.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "professeur")
@Data
public class Professeur extends Personne{
    private String specialite;
    private String grade;

    private List<String> coursIds = new ArrayList<>();
}
