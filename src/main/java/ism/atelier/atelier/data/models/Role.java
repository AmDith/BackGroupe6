package ism.atelier.atelier.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
@Data
public class Role extends AbstractEntity{

}
