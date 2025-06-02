package ism.atelier.atelier.mobile.dto.response;

import ism.atelier.atelier.data.enums.Mensualite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantDtoPointage {
    private String heure;
    private String nomComplet;
    private String nomClasse;
}
