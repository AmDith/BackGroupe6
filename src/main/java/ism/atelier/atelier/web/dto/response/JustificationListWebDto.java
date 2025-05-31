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
    private String absenceId;
    private String pointageId;
    private String statut;

    private String titre;
    private String motifs;
    private String pieceJointe;
}
