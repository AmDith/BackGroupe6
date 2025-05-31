package ism.atelier.atelier.mobile.controllers;

import ism.atelier.atelier.web.dto.response.AbsenceWebDto; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@RequestMapping("/api/etudiant")
public interface EtudiantMobileController {

    @GetMapping("/absences")
    ResponseEntity<Map<String, Object>> getMesAbsences();

    @GetMapping()
    ResponseEntity<Map<String, Object>> listerSesAbsent();

}

