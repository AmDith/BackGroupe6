package ism.atelier.atelier.web.dto.response;

import ism.atelier.atelier.data.enums.EnumJustification;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class JustificationWebDto {
    private String id;
    private LocalDate date;
    private String nomEtudiant;
    private String nomModule;
    private String matricule;
    private String nomClasse;
    private String image;
    private List<String> pieceJointe;
    private String statutJustification;
}
