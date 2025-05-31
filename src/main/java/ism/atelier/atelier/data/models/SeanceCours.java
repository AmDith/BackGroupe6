package ism.atelier.atelier.data.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "seanceCours")
@Data
public class SeanceCours {
    @Id
    private String id;
    private LocalDate date;
    private LocalTime HeureDb;
    private LocalTime HeureFin;

    private String coursId;
    private Boolean Now;
    private List<String> pointageIds = new ArrayList<>();
}