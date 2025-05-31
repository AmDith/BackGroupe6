package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.controllers.JustificationMobileController;
import ism.atelier.atelier.mobile.dto.RestResponseMobile;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.services.AbsenceService;
import ism.atelier.atelier.services.JustificationService;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class JustificationMobileControllerImpl implements JustificationMobileController {
    private final JustificationService justificationService;
    private final JustificationMapper justificationMapper;
    private final AbsenceService absenceService;

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
        var absence = absenceService.getAbsence(justificationDto.getAbsenceId());
        if (absence == null) {
            return ResponseEntity.badRequest().body("Absence non trouvée");
        }
        Justification justification = new Justification();
        justification.setMotifs(justificationDto.getMotifs());
        justification.setTitre(justificationDto.getTitre());
        justification.setPieceJointe(justificationDto.getPieceJointe());
        justification = justificationService.save(justification);

        absence.setJustificationId(justification.getId());
        absenceService.save(absence);

        return ResponseEntity.ok("Justification envoyer avec succes avec succès");
    }

//    @Override
//    public ResponseEntity<JustificationListWebDto> validerJustification(String id, EnumJustification enumJustification) {
//        Justification justification = justificationService.valider(id, enumJustification.name());
//
//        if (justification == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        JustificationListWebDto dto = justificationMapper.toListWebDto(justification);
//        return ResponseEntity.ok(dto);
//    }
//
//    @Override
//    public ResponseEntity<Map<String, Object>> getById(String id) {
//        Justification justification = justificationService.getJustificationById(id);
//        if (justification == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        JustificationListWebDto justificationDto = justificationMapper.toListWebDto(justification);
//        Map<String, Object> response = RestResponseMobile.response(HttpStatus.OK, justificationDto, "");
//
//        return ResponseEntity.ok(response);
//    }
}
