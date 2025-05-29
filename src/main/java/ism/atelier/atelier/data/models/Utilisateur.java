package ism.atelier.atelier.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "utilisateur")
@Data
public class Utilisateur extends Personne{
    private String tel;
    private String login;
    private String password;

    private String roleId;
    private List<String> pointageIds = new ArrayList<>();
    private Etudiant etudiant;
    private Professeur professeur;
}
