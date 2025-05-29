package ism.atelier.atelier.web.dto.response;

import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.Etudiant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class AbsenceListDto {
    private Long id;
    private LocalDate date;
    private Integer HeureDb;
    private Integer HeureFin;
    private Pointer pointer;
    private Etudiant etudiant;
}
