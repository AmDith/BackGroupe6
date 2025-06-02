package ism.atelier.atelier.security.controllers.impl;

import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.security.controllers.UtilisateurSecurityController;
import ism.atelier.atelier.security.dto.RestResponseSecurity;
import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import ism.atelier.atelier.security.dto.response.EtudiantResponseDto;
import ism.atelier.atelier.security.dto.response.UtilisateurResponseDto;
import ism.atelier.atelier.services.*;
import ism.atelier.atelier.utils.mappers.impl.UtilisateurMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class UtilisateurControllerImpl implements UtilisateurSecurityController {

    private final UtilisateurService utilisateurService;
    private final ClasseService classeService;
    private final RoleService roleService;
    private final EtudiantService etudiantService;
    private final PointageService pointageService;

    @Override
    public ResponseEntity<?> connexion(UtilisateurConneteDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            Utilisateur utilisateur = utilisateurService.seConnecter(UtilisateurMapper.toEntity(user));
            Role role = roleService.findById(utilisateur.getRoleId());

            // Si c'est un étudiant
            if (utilisateur.getEtudiantId() != null) {
                Etudiant etudiant = etudiantService.findById(utilisateur.getEtudiantId());
                String nomClasse = null;
                List<Pointage> pointages = new ArrayList<>();
                for (String pointageId : etudiant.getPointageIds()) {
                    if (pointageId != null) {
                        Pointage pointage = pointageService.getById(pointageId);
                        if (pointage != null) {
                            pointages.add(pointage);
                        }
                    }
                }

                if (etudiant != null && etudiant.getClasseId() != null) {
                    Classe classe = classeService.getClasse(etudiant.getClasseId());
                    if (classe != null) {
                        nomClasse = classe.getName();
                    }
                }

                EtudiantResponseDto etudiantDto = UtilisateurMapper.toEtudiantResponseDto(utilisateur, etudiant, nomClasse);
                Map<String, Object> response = RestResponseSecurity.response(
                        HttpStatus.OK,
                        etudiantDto,
                        "utilisateurResponseDto"
                );
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            // Professeur, admin ou vigile
            UtilisateurResponseDto utilisateurResponseDto = UtilisateurMapper.toUtilisateurResponseDto(utilisateur, role);
            Map<String, Object> response = RestResponseSecurity.response(
                    HttpStatus.OK,
                    utilisateurResponseDto,
                    "utilisateurResponseDto"
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
