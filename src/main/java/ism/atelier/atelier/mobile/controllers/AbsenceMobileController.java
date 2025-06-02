package ism.atelier.atelier.mobile.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/api/mobile/absences")
public interface AbsenceMobileController {
    @GetMapping("/listeAbsents/{etudiantId}")
    public ResponseEntity<Map<String, Object>> listerSesAbsent(@PathVariable String etudiantId);
}
