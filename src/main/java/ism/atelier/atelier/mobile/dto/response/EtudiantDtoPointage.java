package ism.atelier.atelier.mobile.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantDtoPointage {
    private String heure;
    private String nomComplet;
    private String nomClasse;
    private String image;
}
