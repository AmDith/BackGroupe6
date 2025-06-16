package ism.atelier.atelier.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import ism.atelier.atelier.mobile.dto.response.ValidationJustificationDto;
import ism.atelier.atelier.services.AbsenceService;
import ism.atelier.atelier.services.JustificationService;
import ism.atelier.atelier.services.PointageService;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.controllers.JustificationWebController;
import ism.atelier.atelier.web.dto.request.JustificationWebRequestDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import ism.atelier.atelier.web.dto.response.JustificationWebResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Tag(name="JustificationController", description = "Envoi d une justification")
public class JustificationWebControllerImpl implements JustificationWebController {
    private final AbsenceService absenceService;
    private final JustificationService justificationService;
    private final PointageService pointageService;
    private final JustificationMapper justificationMapper;

    @Override
    public ResponseEntity<?> Validerjustificatif(JustificationWebRequestDto justificationWebRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        var absence = absenceService.getAbsence(justificationWebRequestDto.getJustificationId());
        if (absence == null) {
            return ResponseEntity.badRequest().body("Absence non trouvée");
        }
//       absence.setJustificationId(validationjustificationDto.getStatut());
        absenceService.save(absence);
        return ResponseEntity.ok("Justification " + justificationWebRequestDto.getDecision().toLowerCase() + " avec succès");
    }

    @Override
    public ResponseEntity<?> validationJustification(JustificationWebRequestDto dto) {
        try {
            JustificationWebResponseDto response = justificationService.validerJustification(dto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
//        JustificationWebResponseDto response = justificationService.validerJustification(dto);
//        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<JustificationListWebDto>> listerJustifications() {
        List<JustificationListWebDto> list = justificationService.listerJustificationsWeb();
        return ResponseEntity.ok(list);
    }


//    @Override
//    public ResponseEntity<List<JustificationListWebDto>> listerJustification() {
//        List<Absence> absences = absenceService.getAllAsenceJustifier();
//
//        List<JustificationListWebDto> result = absences.stream()
//                .map(absence -> {
////                    var justification = justificationService.getJustificationById(absence.getJustificationId());
////                    return justificationMapper.toListWebDto(absence, justification);
//                })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(result);



//        List<Justification> justification = justificationService.findAll();
//
//        List<JustificationListAdmin> dtos = justification.stream()
//                .map(absence -> {
//                    try {
//                        Pointage pointage = pointageService.getById(absence.getPointageId());
//                        if (pointage == null) return null;
//
//                        Etudiant etudiant = etudiantService.findById(pointage.getEtudiant());
//                        if (etudiant == null) return null;
//
//                        SeanceCours seance = seanceCoursService.findById(pointage.getSeanceCours());
//                        if (seance == null) return null;
//
//                        Cours cours = coursService.findById(seance.getCoursId());
//                        if (cours == null) return null;
//
//                        Module module = moduleService.findById(cours.getModuleId());
//                        Classe classe = classeService.getClasse(etudiant.getClasseId());
//
//                        return AbsenceListWebDto.builder()
//                                .id(absence.getId())
//                                .date(seance.getDate())
//                                .nomEtudiant(etudiant.getNomComple())
//                                .matricule(etudiant.getMatriculeE())
//                                .nomClasse(classe != null ? classe.getName() : "Classe inconnue")
//                                .nomModule(module != null ? module.getName() : "Module inconnu")
//                                .image("default.jpg") // Mettre l’image réelle si elle existe
//                                .etatAbsene(absence.getJustificationId() != null ? "JUSTIFIE" : "NON-JUSTIFIE")
//                                .build();
//
//                    } catch (Exception e) {
//                        System.out.println("⚠ Erreur lors de la construction d'une absence DTO : " + e.getMessage());
//                        return null;
//                    }
//                })
//                .filter(Objects::nonNull)
//                .toList();
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", 200);
//        response.put("data", dtos);
//        response.put("message", "Liste des absences récupérée avec succès");
//
//        return ResponseEntity.ok(response);

//    }
}

//{
//        "justifications": [
//        {
//        "absenceId": "abc123",
//        "pointageId": "p001",
//        "statut": "VALIDE",
//        "titre": "Rendez-vous médical",
//        "motifs": "Consultation chez le médecin",
//        "pieceJointe": "ordonnance.pdf"
//        },
//        ...
//        ],
//        "total": 4
//        }
