package ism.atelier.atelier.mobile.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class AbsenceMobileDto {
    private String id;
    private String date;
    private String nomCours;
    private String horaire;
    private String etat;
    private boolean peutJustifier;
}
