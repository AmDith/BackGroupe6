package ism.atelier.atelier.mobile.controllers;

import ism.atelier.atelier.mobile.dto.request.EtudiantScanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/pointage")
public interface PointageController {
    @PostMapping("/pointer")
    public ResponseEntity<?> pointageEtudiant(@RequestBody EtudiantScanDto etudiantScanDto, BindingResult bindingResult);
}
