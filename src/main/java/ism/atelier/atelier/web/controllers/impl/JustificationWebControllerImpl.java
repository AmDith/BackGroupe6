package ism.atelier.atelier.web.controllers.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.services.*;
import ism.atelier.atelier.utils.mappers.impl.JustificationMapper;
import ism.atelier.atelier.web.controllers.JustificationWebController;
import ism.atelier.atelier.web.dto.RestResponseWeb;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationWebDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequiredArgsConstructor
public class JustificationWebControllerImpl implements JustificationWebController {
    private final AbsenceService absenceService;
    private final JustificationService justificationService;
    private final PointageService pointageService;
    private final EtudiantService etudiantService;
    private final SeanceCoursService seanceCoursService;
    private final CoursService coursService;
    private final ModuleService moduleService;
    private final ClasseService classeService;

    @Override
    public ResponseEntity<?> Validerjustificatif(String justificationId, ValiderJustificationDto validationjustificationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        var justification = justificationService.findById(justificationId);
        if (justification == null) {
            return ResponseEntity.status(404).body("Justification non trouvée");
        }

        try {
            justification.setEnumJustification(EnumJustification.valueOf(
                    validationjustificationDto.getEnumJustification()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Valeur de justification invalide. Options : Valider, Rejeter...");
        }

        justificationService.save(justification);

        return ResponseEntity.ok("Justification " +
                validationjustificationDto.getEnumJustification().toLowerCase() + " avec succès.");
    }

    @Override
    public ResponseEntity<Map<String, Object>> listerJustification() {
        List<Absence> absences = absenceService.findAll();
        List<JustificationWebDto> dtos = new ArrayList<>();

        for (Absence absence : absences) {
            if (absence.getJustificationId() == null) continue;

            Justification justification = justificationService.findById(absence.getJustificationId());
            if (justification == null) continue;

            Pointage pointage = pointageService.getById(absence.getPointageId());
            if (pointage == null) continue;

            Etudiant etudiant = etudiantService.findById(pointage.getEtudiant());
            SeanceCours seance = seanceCoursService.findById(pointage.getSeanceCours());
            if (seance == null || etudiant == null) continue;

            Cours cours = coursService.findById(seance.getCoursId());
            if (cours == null) continue;

            Module module = moduleService.findById(cours.getModuleId());
            Classe classe = classeService.getClasse(etudiant.getClasseId());

            JustificationWebDto dto = JustificationMapper.toWebDto(etudiant, seance, module, classe, justification);
            dtos.add(dto);
        }

        Map<String, Object> response = RestResponseWeb.response2(
                HttpStatus.OK,
                dtos,
                "AbsenceJustifieeWebDto"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
