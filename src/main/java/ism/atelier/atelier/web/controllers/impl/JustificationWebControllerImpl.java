package ism.atelier.atelier.web.controllers.impl;

import ism.atelier.atelier.web.controllers.JustificationWebController;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Map;

public class JustificationWebControllerImpl implements JustificationWebController {
    @Override
    public ResponseEntity<?> Validerjustificatif(ValiderJustificationDto ValidationjustificationDto, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> listerJustification() {
        return null;
    }
}
