package ism.atelier.atelier.web.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JustificationWebResponseDto {
    private String id;
    private String titre;
    private String motif;
    private String urlPieceJointe;
    private String absenceId;
    private String etat;
//    private String justificationId;
//    private String etat;
}
