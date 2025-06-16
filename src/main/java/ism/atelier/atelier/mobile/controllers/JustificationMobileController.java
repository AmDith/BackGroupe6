package ism.atelier.atelier.mobile.controllers;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.mobile.dto.request.JustificationRequestDto;
import ism.atelier.atelier.mobile.dto.response.JustificationResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RequestMapping("/api/justification")
public interface JustificationMobileController {
//    @PostMapping("/justificatifAbsent")
//    ResponseEntity<?> justificatif(@Valid @RequestBody JustificationAbsentDto justificationDto,
//                                   BindingResult bindingResult);

    @PostMapping("/absence/{absenceId}")
    public ResponseEntity<JustificationResponseDto> justifierAbsence(
            @PathVariable String absenceId,
            @ModelAttribute JustificationRequestDto dto,
            @RequestParam("titre") String titre,
            @RequestParam("motif") String motif,
            @RequestParam(value = "pieceJointe", required = false) MultipartFile pieceJointe
    );
}