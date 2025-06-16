package ism.atelier.atelier.web.controllers;

import ism.atelier.atelier.mobile.dto.response.ValidationJustificationDto;
import ism.atelier.atelier.web.dto.request.JustificationWebRequestDto;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import ism.atelier.atelier.web.dto.response.JustificationWebResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Map;

@RequestMapping("/api/web/justification")
public interface JustificationWebController {
    @PostMapping("/validation")
    public ResponseEntity<?> Validerjustificatif(@Valid @RequestBody JustificationWebRequestDto justificationWebRequestDto,
                                                 BindingResult bindingResult);

    @PutMapping("/valider")
    ResponseEntity<?> validationJustification(
                @RequestBody JustificationWebRequestDto dto);
//    @GetMapping("/listes")
//    ResponseEntity<List<JustificationListWebDto>> listerJustification();
//    public ResponseEntity<Map<String, Object>> listerJustification();
    @GetMapping("/lister")
    ResponseEntity<List<JustificationListWebDto>> listerJustifications();
}
//http://localhost:3000/justificationPost
//http://localhost:3000/absencesListWebDto
//http://localhost:3000/justificationsListWebDto