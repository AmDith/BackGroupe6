package ism.atelier.atelier.security.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class EtudiantResponseDto {
    private String id;
    private String matriculeE;
    private String nomComplet;
    private String nomClasse;
    private String roleId;
    private List<AbsenceListSecurityDto> absenceListerDtoIds;
}