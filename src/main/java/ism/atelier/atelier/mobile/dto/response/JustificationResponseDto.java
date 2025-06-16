package ism.atelier.atelier.mobile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JustificationResponseDto {
    private String id;
    private String titre;
    private String motif;
    private String urlPieceJointe;
    private String absenceId;
}
