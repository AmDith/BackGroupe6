package ism.atelier.atelier.mobile.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JustificationAbsentDto {
    private String absenceId;
    @NotNull(message = "Le motif est obligatoire")
    private String motifs;
    @NotNull(message = "Le titre est obligatoire")
    private String titre;
    private String pieceJointe;
}
