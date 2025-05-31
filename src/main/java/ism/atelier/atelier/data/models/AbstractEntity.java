package ism.atelier.atelier.data.models;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import lombok.Data;


@Data
@Setter
public class AbstractEntity {
    @Id
    private String id;
    protected String name;

}
