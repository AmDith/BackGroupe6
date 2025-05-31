package ism.atelier.atelier.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AbsenceWebDto {
    private String nomComplet;
    private String matricule;
    private String classe;
    private LocalDate date;
    private String matiere;
    private String statut;
}

