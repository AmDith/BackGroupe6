package ism.atelier.atelier.mobile.controllers;

import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/mobile/justification")
public interface JustificationMobileController {
    @PostMapping("/justificatifAbsent")
    public ResponseEntity<?> justificatif(@ModelAttribute JustificationAbsentDto justificationDto, BindingResult bindingResult);
}