package ism.atelier.atelier.data.models;

import ism.atelier.atelier.data.enums.EnumJustification;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "justifications")
@Data
public class Justification {
    @Id
    private String id;
    private String motifs;
    private String titre;
    private List<String> pieceJointe;
    private EnumJustification enumJustification;
}
