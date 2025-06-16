package ism.atelier.atelier.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JustificationWebRequestDto {
    private String justificationId;
    private String decision;
}
