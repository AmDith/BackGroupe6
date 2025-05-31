package ism.atelier.atelier.data.models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vigile")
@Data
public class Vigile extends Personne {



}
