package ism.atelier.atelier.web.controllers.impl;

import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.services.*;
import ism.atelier.atelier.utils.mappers.impl.AbsenceMapper;
import ism.atelier.atelier.web.controllers.AbsenceWebController;
import ism.atelier.atelier.web.dto.RestResponseWeb;
import ism.atelier.atelier.web.dto.response.AbsenceListWebDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class AbsenceWebControllerImpl implements AbsenceWebController {

    private final AbsenceService absenceService;
    private final PointageService pointageService;
    private final EtudiantService etudiantService;
    private final SeanceCoursService seanceCoursService;
    private final CoursService coursService;
    private final ModuleService moduleService;
    private final ClasseService classeService;

    @Override
    public ResponseEntity<Map<String, Object>> listerAbsents() {
        List<Absence> absences = absenceService.findAll();
        List<AbsenceListWebDto> dtos = new ArrayList<>();

        for (Absence absence : absences) {
            Pointage pointage = pointageService.getById(absence.getPointageId());
            if (pointage == null) continue;

            Etudiant etudiant = etudiantService.findById(pointage.getEtudiant());
            SeanceCours seance = seanceCoursService.findById(pointage.getSeanceCours());
            if (seance == null || etudiant == null) continue;

            Cours cours = coursService.findById(seance.getCoursId());
            if (cours == null) continue;

            Module module = moduleService.findById(cours.getModuleId());
            Classe classe = classeService.getClasse(etudiant.getClasseId());

            AbsenceListWebDto dto = AbsenceMapper.toWebDto(absence, etudiant, seance, module, classe);
            dtos.add(dto);
        }

        Map<String, Object> response = RestResponseWeb.response2(
                HttpStatus.OK,
                dtos,
                "AbsenceListWebDto"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

