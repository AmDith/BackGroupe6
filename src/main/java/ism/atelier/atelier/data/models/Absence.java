package ism.atelier.atelier.data.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "absence")
@Data

public class Absence {
    @Id
    private String id;
    private String  justificationId;
    private String pointageId;
}
