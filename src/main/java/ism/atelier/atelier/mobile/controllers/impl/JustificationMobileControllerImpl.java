package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.mobile.controllers.JustificationMobileController;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class JustificationMobileControllerImpl implements JustificationMobileController {
    @Override
    public ResponseEntity<?> justificatif(JustificationAbsentDto justificationDto, BindingResult bindingResult) {
        return null;
    }
}
