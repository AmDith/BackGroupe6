package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.mobile.controllers.EtudiantMobileController;
import ism.atelier.atelier.services.EtudiantService;
import ism.atelier.atelier.services.impl.absenceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EtudiantMobileControllerImpl implements EtudiantMobileController {

    private final EtudiantService etudiantService;
    

    @Override
    public ResponseEntity<Map<String, Object>> getMesAbsences() {
        AbsenceWebDto absenceWebDto;
        return null;
        // return etudiantService.getAbsencesEtudiantConnecte().
        // List<AbsenceWebDto> absences = etudiantService.getAbsencesEtudiantConnecte();
        // return ResponseEntity.ok(absences);
    }


    @Override
    public ResponseEntity<Map<String, Object>> listerSesAbsent() {
        return null;
    }
}

