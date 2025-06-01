package ism.atelier.atelier.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.mobile.dto.response.ValidationJustificationDto;
import ism.atelier.atelier.services.AbsenceService;
import ism.atelier.atelier.services.JustificationService;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.controllers.JustificationWebController;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Tag(name="JustificationController", description = "Envoi d une justification")
public class JustificationWebControllerImpl implements JustificationWebController {
    private final AbsenceService absenceService;
    private final JustificationService justificationService;
    private final JustificationMapper justificationMapper;

    @Override
    public ResponseEntity<?> Validerjustificatif(ValidationJustificationDto validationjustificationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        var absence = absenceService.getAbsence(validationjustificationDto.getAbsenceId());
        if (absence == null) {
            return ResponseEntity.badRequest().body("Absence non trouvée");
        }
       absence.setStatut(validationjustificationDto.getStatut());
        absenceService.save(absence);
        return ResponseEntity.ok("Justification " + validationjustificationDto.getStatut().toLowerCase() + " avec succès");
    }

    @Override
    public ResponseEntity<List<JustificationListWebDto>> listerJustification() {
        List<Absence> absences = absenceService.getAllAsenceJustifier();

        List<JustificationListWebDto> result = absences.stream()
                .map(absence -> {
                    var justification = justificationService.getJustificationById(absence.getJustificationId());
                    return justificationMapper.toListWebDto(absence, justification);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}

//{
//        "justifications": [
//        {
//        "absenceId": "abc123",
//        "pointageId": "p001",
//        "statut": "VALIDE",
//        "titre": "Rendez-vous médical",
//        "motifs": "Consultation chez le médecin",
//        "pieceJointe": "ordonnance.pdf"
//        },
//        ...
//        ],
//        "total": 4
//        }
