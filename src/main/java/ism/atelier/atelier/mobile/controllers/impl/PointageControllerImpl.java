package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.mobile.controllers.PointageController;
import ism.atelier.atelier.mobile.dto.request.EtudiantScanDto;
import ism.atelier.atelier.services.impl.EtudiantServiceImpl;
import ism.atelier.atelier.services.impl.PointageServiceImpl;
import ism.atelier.atelier.utils.mappers.impl.EtudiantMapper;
import ism.atelier.atelier.utils.mappers.impl.PointageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PointageControllerImpl implements PointageController {
    private final PointageServiceImpl pointageService;
    private final EtudiantServiceImpl etudiantService;

    @Override
    public ResponseEntity<?> pointageEtudiant(EtudiantScanDto etudiantScanDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        var etudiant = etudiantService.findByMatricule(etudiantScanDto.getMatriculeE());
        if (etudiant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant introuvable");
        }
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        return null;
    }
}
