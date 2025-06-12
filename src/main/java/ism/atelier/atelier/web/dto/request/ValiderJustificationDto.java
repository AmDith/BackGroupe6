package ism.atelier.atelier.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValiderJustificationDto {
    @NotBlank
    private String enumJustification;
}
