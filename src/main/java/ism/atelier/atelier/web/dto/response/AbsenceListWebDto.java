package ism.atelier.atelier.web.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class AbsenceListWebDto {
    private String id;
    private LocalDateTime date;
    private String heureDb;
    private String heureFin;
    private String nomEtudiant;
    private String nomModule;
    private String matricule;
    private String nomClasse;
    private String image;
    private String etatAbsence;
}
