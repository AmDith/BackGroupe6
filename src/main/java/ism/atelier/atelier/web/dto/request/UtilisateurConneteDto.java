package ism.atelier.atelier.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurConneteDto {
    @NotNull(message = "Le login est obligatoire")
    private String login;
    @NotNull(message = "Le mot de passe est obligatoire")
    private String password;
}
