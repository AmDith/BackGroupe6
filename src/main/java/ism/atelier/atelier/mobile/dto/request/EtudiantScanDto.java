package ism.atelier.atelier.mobile.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantScanDto {
    private String QRmatricule;
    private String utilisateurId;
}
