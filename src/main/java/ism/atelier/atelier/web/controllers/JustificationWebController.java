package ism.atelier.atelier.web.controllers;

import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/api/justification")
public interface JustificationWebController {
    @PostMapping("/validation")
    public ResponseEntity<?> Validerjustificatif(@Valid @RequestBody ValiderJustificationDto ValidationjustificationDto, BindingResult bindingResult);
    @GetMapping("/listes")
    public ResponseEntity<Map<String, Object>> listerJustification();
}
