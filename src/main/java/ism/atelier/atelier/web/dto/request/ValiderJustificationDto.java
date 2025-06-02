package ism.atelier.atelier.web.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValiderJustificationDto {
    private String justificationId;
    private String enumJustification;
}
