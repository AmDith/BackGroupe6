package ism.atelier.atelier.security.controllers.impl;

import ism.atelier.atelier.data.models.Classe;
import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.data.repository.ClasseRepository;
import ism.atelier.atelier.security.controllers.UtilisateurSecurityController;
import ism.atelier.atelier.security.dto.RestResponseSecurity;
import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import ism.atelier.atelier.services.ClasseService;
import ism.atelier.atelier.services.UtilisateurService;
import ism.atelier.atelier.utils.mappers.impl.UtilisateurMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
public class UtilisateurControllerImpl implements UtilisateurSecurityController {
    private final UtilisateurService utilisateurService;
    private final ClasseService classeService;

    @Override
    public ResponseEntity<?> connexion( UtilisateurConneteDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            Utilisateur utilisateur = utilisateurService.seConnecter(UtilisateurMapper.toEntity(user));

            if (utilisateur.getEtudiant() != null) {
                String nomClasse = null;
                if (utilisateur.getEtudiant().getClasseId() != null) {
                    Classe classe = classeService.getClasse(utilisateur.getEtudiant().getClasseId());
                    if (classe != null) {
                        nomClasse = classe.getName();
                    }
                }
                var etudiantResponseDto = UtilisateurMapper.toEtudiantResponseDto(utilisateur, nomClasse);
                Map<String, Object> response = RestResponseSecurity.response(
                        HttpStatus.OK,
                        etudiantResponseDto,
                        "etudiantResponseDto"
                );
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            // ✅ Sinon, est-ce un professeur ?
            if (utilisateur.getEtudiant() == null){
                var utilisateurResponseDto = UtilisateurMapper.toUtilisateurResponseDto(utilisateur);
                Map<String, Object> response = RestResponseSecurity.response(
                        HttpStatus.OK,
                        utilisateurResponseDto,
                        "utilisateurResponseDto"
                );
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
