package ism.atelier.atelier.security.controllers;

import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/utilisateur")
public interface UtilisateurSecurityController {
    @PostMapping("/login")
    public ResponseEntity<?> connexion(@Valid @RequestBody UtilisateurConneteDto user, BindingResult bindingResult);
}
