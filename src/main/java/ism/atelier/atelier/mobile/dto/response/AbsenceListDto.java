package ism.atelier.atelier.mobile.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class AbsenceListDto {
    private String id;
    private LocalDateTime date;
    private String HeureDb;
    private String HeureFin;
    private String etatPointage;
    private String nomModule;
}
