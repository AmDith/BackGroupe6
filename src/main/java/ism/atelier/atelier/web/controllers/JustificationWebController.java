package ism.atelier.atelier.web.controllers;

import ism.atelier.atelier.mobile.dto.response.ValidationJustificationDto;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import java.util.Map;

@RequestMapping("/api/justification")
public interface JustificationWebController {
    @PostMapping("/validation")
    public ResponseEntity<?> Validerjustificatif(@Valid @RequestBody ValidationJustificationDto ValidationjustificationDto, BindingResult bindingResult);
    @GetMapping("/listes")
    ResponseEntity<List<JustificationListWebDto>> listerJustification();
//    public ResponseEntity<Map<String, Object>> listerJustification();
}
