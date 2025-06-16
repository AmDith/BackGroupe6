package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.controllers.JustificationMobileController;
import ism.atelier.atelier.mobile.dto.RestResponseMobile;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.mobile.dto.request.JustificationRequestDto;
import ism.atelier.atelier.mobile.dto.response.JustificationResponseDto;
import ism.atelier.atelier.services.AbsenceService;
import ism.atelier.atelier.services.JustificationService;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class JustificationMobileControllerImpl implements JustificationMobileController {
    private final JustificationService justificationService;
    private final JustificationMapper justificationMapper;
    private final AbsenceService absenceService;;

//    public ResponseEntity<JustificationResponseDto> justifierAbsence(String absenceId, JustificationRequestDto dto)  {
//        JustificationResponseDto response = justificationService.creerJustification(absenceId, dto);
//        return ResponseEntity.ok(response);
//    }

        @PostMapping("/absence/{absenceId}")
        public ResponseEntity<JustificationResponseDto> justifierAbsence(
                @PathVariable String absenceId,
                @ModelAttribute JustificationRequestDto dto,

                @RequestParam("titre") String titre,
                @RequestParam("motif") String motif,
                @RequestParam(value = "pieceJointe", required = false) MultipartFile pieceJointe) {

            JustificationRequestDto requestDto = JustificationRequestDto.builder()
                    .titre(titre)
                    .motif(motif)
                    .pieceJointe(pieceJointe)
                    .build();

            JustificationResponseDto response = justificationService.creerJustification(absenceId, dto);
            return ResponseEntity.ok(response);
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
