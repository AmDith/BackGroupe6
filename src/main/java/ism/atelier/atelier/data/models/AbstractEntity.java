package ism.atelier.atelier.data.models;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import lombok.Data;


@Data
public class AbstractEntity {
    @Id
    private String id;
    private String name;


}
