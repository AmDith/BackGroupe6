package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.mobile.controllers.PointageController;
import ism.atelier.atelier.mobile.dto.request.EtudiantScanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class PointageControllerImpl implements PointageController {
    @Override
    public ResponseEntity<?> pointageEtudiant(EtudiantScanDto etudiantScanDto, Long utilisateurId, BindingResult bindingResult) {
        return null;
    }
}
