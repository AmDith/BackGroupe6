package ism.atelier.atelier.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class JustificationWebDto {
    private String id;
    private String nomComplet;
    private String matricule;
    private String classe;
    private LocalDate date;
    private String matiere;
    private String statutJustification;
}
