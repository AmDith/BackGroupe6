package ism.atelier.atelier.data.models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "anneeScolaire")
@Data
public class AnneeScolaire extends AbstractEntity{
}
