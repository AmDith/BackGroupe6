package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.mobile.controllers.AbsenceMobileController;
import ism.atelier.atelier.mobile.dto.RestResponseMobile;
import ism.atelier.atelier.mobile.dto.response.AbsenceListDto;
import ism.atelier.atelier.services.*;
import ism.atelier.atelier.utils.mappers.impl.AbsenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AbsenceMobileControllerImpl implements AbsenceMobileController {

    private final EtudiantService etudiantService;
    private final PointageService pointageService;
    private final AbsenceService absenceService;
    private final SeanceCoursService seanceCoursService;
    private final CoursService coursService;
    private final ModuleService moduleService;

    @Override
    public ResponseEntity<Map<String, Object>> listerSesAbsent(String etudiantId) {
        Etudiant etudiant = etudiantService.findById(etudiantId);
        if (etudiant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Étudiant non trouvé"));
        }

        List<AbsenceListDto> absenceDtos = new ArrayList<>();

        for (String pointageId : etudiant.getPointageIds()) {
            Pointage pointage = pointageService.getById(pointageId);
            if (pointage == null || pointage.getPointer() != Pointer.Absent) continue;

            Absence absence = absenceService.findById(pointage.getAbsenceId());
            if (absence == null) continue;

            SeanceCours seance = seanceCoursService.findById(pointage.getSeanceCours());
            if (seance == null) continue;

            Cours cours = coursService.findById(seance.getCoursId());
            if (cours == null) continue;

            Module module = moduleService.findById(cours.getModuleId());
            if (module == null) continue;

            AbsenceListDto dto = AbsenceMapper.toAbsenceListDto(absence, seance, module);
            absenceDtos.add(dto);

        }
        Map<String, Object> response = RestResponseMobile.response2(
                HttpStatus.OK,
                absenceDtos,
                "AbsenceListDto"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
