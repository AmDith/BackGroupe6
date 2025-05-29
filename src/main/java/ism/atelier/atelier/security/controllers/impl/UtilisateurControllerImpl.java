package ism.atelier.atelier.security.controllers.impl;

import ism.atelier.atelier.security.controllers.UtilisateurSecurityController;
import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class UtilisateurControllerImpl implements UtilisateurSecurityController {
    @Override
    public ResponseEntity<?> connexion(UtilisateurConneteDto user, BindingResult bindingResult) {
        return null;
    }
}
