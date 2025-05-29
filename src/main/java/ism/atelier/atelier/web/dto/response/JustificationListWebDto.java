package ism.atelier.atelier.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class JustificationListWebDto {
    private Long id;
    private LocalDate date;
    private String nomEtudiant;
    private String nomModule;
    private String matricule;
    private String nomClasse;
}
