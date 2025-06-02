package ism.atelier.atelier.mobile.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class AbsenceListDto {
    private String id;
    private LocalDate date;
    private String HeureDb;
    private String HeureFin;
    private String etatPointage;
    private String nomModule;
}
