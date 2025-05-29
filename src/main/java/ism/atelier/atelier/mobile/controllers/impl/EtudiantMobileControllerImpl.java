package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.mobile.controllers.EtudiantMobileController;
import ism.atelier.atelier.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EtudiantMobileControllerImpl implements EtudiantMobileController {

    private final EtudiantService etudiantService = null;
    

    @Override
    public ResponseEntity<List<AbsenceWebDto>> getMesAbsences() {
        List<AbsenceWebDto> absences = etudiantService.getAbsencesEtudiantConnecte();
        return ResponseEntity.ok(absences);
    }


    @Override
    public ResponseEntity<Map<String, Object>> listerSesAbsent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerSesAbsent'");
    }
}

