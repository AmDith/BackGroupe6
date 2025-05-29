package ism.atelier.atelier.security.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurResponseDto {
    private Long id;
    private String nomUtilisateur;
}
