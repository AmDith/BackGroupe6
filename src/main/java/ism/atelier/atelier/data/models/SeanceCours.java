package ism.atelier.atelier.data.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "seanceCours")
@Data
public class SeanceCours {
    @Id
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Field(targetType = FieldType.STRING)
    private LocalDate date;
    private LocalTime HeureDb;
    private LocalTime HeureFin;
    private boolean isNow;

    private String coursId;
    private List<String> pointageIds = new ArrayList<>();
}