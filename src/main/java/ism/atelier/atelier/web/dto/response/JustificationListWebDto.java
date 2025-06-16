package ism.atelier.atelier.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JustificationListWebDto {

    private String justificationId;
    private String justificationdate;
    private String justificationnomEtudiant;
    private String justificationnomModule;
    private String justificationmatricule;
    private String justificationnomClasse;
//    private String justificationimages;
    private String ejustificationtatAbsence;

    private String nomComplet;
    private String matricule;
    private String classe;
    private String date;
    private String cours;
    private String etat;

//    private String id;
//    private String date;
//    private String nomEtudiant;
//    private String nomModule;
//    private String matricule;
//    private String nomClasse;
//    private String images;
//    private String etatAbsence;


}

