package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.controllers.JustificationMobileController;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.services.AbsenceService;
import ism.atelier.atelier.services.FileUploadService;
import ism.atelier.atelier.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class JustificationMobileControllerImpl implements JustificationMobileController {

    private final JustificationService justificationService;
    private final AbsenceService absenceService;
    private final FileUploadService fileUploadService;
    @Override
    public ResponseEntity<?> justificatif(JustificationAbsentDto justificationDto,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Absence absence = absenceService.getAbsence(justificationDto.getAbsenceId());
        if (absence == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Absence introuvable");
        }

        List<String> urls = fileUploadService.uploadMultipleFiles(justificationDto.getPiecesJointes());

        Justification justification = new Justification();
        justification.setTitre(justificationDto.getTitre());
        justification.setMotifs(justificationDto.getMotifs());
        justification.setEnumJustification(EnumJustification.EnCours);
        justification.setPieceJointe(urls);
        justification = justificationService.save(justification);
        absence.setJustificationId(justification.getId());
        absenceService.save(absence);

        return ResponseEntity.ok("Justification envoyée avec succès");
    }
}
