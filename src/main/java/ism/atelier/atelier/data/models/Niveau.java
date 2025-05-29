package ism.atelier.atelier.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "niveau")
@Data
public class Niveau  extends AbstractEntity{
    private List<String> classeIds = new ArrayList<>();
}
