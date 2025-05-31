package ism.atelier.atelier.security.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurResponseDto {
    private String id;
    private String nomUtilisateur;
    private String nomRole;
}
