package ism.atelier.atelier.mobile.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ValidationJustificationDto {
    private String absenceId;

    @NotNull(message = "Le statut est obligatoire") // "VALIDER" ou "REFUSER"
    private String statut;
}
