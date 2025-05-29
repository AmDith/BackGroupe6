package ism.atelier.atelier.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/api/abscence")
public interface AbsenceWebController {
    @GetMapping("/listes")
    public ResponseEntity<Map<String, Object>> listerAbsents();
}
