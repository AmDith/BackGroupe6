package ism.atelier.atelier.mobile.controllers;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/justification")
public interface JustificationMobileController {
    @PostMapping("/justificatifAbsent")
    ResponseEntity<?> justificatif(@Valid @RequestBody JustificationAbsentDto justificationDto,
                                   BindingResult bindingResult);

//    @PutMapping("/{id}/valider")
//    ResponseEntity<?> validerJustification(@PathVariable String id, @RequestParam EnumJustification enumJustification);

//    @GetMapping("/{id}")
//    ResponseEntity<Map<String, Object>> getById(@PathVariable String id);
}