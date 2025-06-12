package ism.atelier.atelier.web.controllers;

import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/justification")
public interface JustificationWebController {
    @PutMapping("/validation/{justificationId}")
    public ResponseEntity<?> Validerjustificatif(@PathVariable String justificationId,@Valid @RequestBody ValiderJustificationDto validationjustificationDto, BindingResult bindingResult);
    @GetMapping("/listes")
    public ResponseEntity<Map<String, Object>> listerJustification();
}