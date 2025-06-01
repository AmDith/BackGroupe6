package ism.atelier.atelier.security.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class AbsenceListSecurityDto {
    private String id;
    private LocalDate date;
    private String HeureDb;
    private String HeureFin;
    private String etatPointage;
    private String nomModule;
}
