package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.Classe;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.mobile.controllers.PointageController;
import ism.atelier.atelier.mobile.dto.request.EtudiantScanDto;
import ism.atelier.atelier.security.dto.RestResponseSecurity;
import ism.atelier.atelier.services.*;
import ism.atelier.atelier.utils.mappers.impl.EtudiantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PointageControllerImpl implements PointageController {
    private final PointageService pointageService;
    private final EtudiantService etudiantService;
    private final CoursService coursService;
    private final SeanceCoursService seanceCoursService;
    private final ClasseService classeService;


    @Override
    public ResponseEntity<?> pointageEtudiant(EtudiantScanDto etudiantScanDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        var etudiant = etudiantService.findByMatricule(etudiantScanDto.getQRmatricule());
        System.out.println(etudiant);
        if (etudiant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant introuvable");
        }


        LocalTime nowTime = LocalTime.now();
        System.out.println(etudiant.getClasseId());
        var cours = coursService.getCoursActifDeLaClasse(etudiant.getClasseId());
        System.out.println(cours);
        if (cours == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aucun cours actif trouvé pour la classe de l'étudiant.");
        }

        var seanceCours = seanceCoursService.getSeanceActuelleDuCours(cours);
        System.out.println(seanceCours);
        if (seanceCours == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune séance en cours");
        }

        Duration dureeSeance = Duration.between(seanceCours.getHeureDb(), seanceCours.getHeureFin());

        LocalTime debutIntervalle1 = seanceCours.getHeureDb();
        LocalTime finIntervalle1 = seanceCours.getHeureDb().plusMinutes(30);
        LocalTime debutIntervalle2 = seanceCours.getHeureDb().plusMinutes(210);
        LocalTime finIntervalle2 = seanceCours.getHeureFin();

        boolean estDansIntervalle1 = !nowTime.isBefore(debutIntervalle1) && !nowTime.isAfter(finIntervalle1);
        boolean estDansIntervalle2 = dureeSeance.toHours() > 2 && !nowTime.isBefore(debutIntervalle2) && !nowTime.isAfter(finIntervalle2);

        if (!estDansIntervalle1 && !estDansIntervalle2) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("⛔ Hors de l'intervalle de pointage autorisé !");
        }

        List<Pointage> pointages = pointageService.getPointagesBySeance(seanceCours.getId());
        List<Pointage> pointagesEtudiant = pointages.stream()
                .filter(p -> etudiant.getId().equals(p.getEtudiant()) && p.getEtudiant() != null)
                .toList();

        boolean aPointeIntervalle1 = pointagesEtudiant.stream()
                .anyMatch(p -> {
                    if (p.getHeurePointage() == null) return false;
                    LocalTime heureP = p.getHeurePointage();
                    return !heureP.isBefore(debutIntervalle1) && !heureP.isAfter(finIntervalle1);
                });

        boolean aPointeIntervalle2 = pointagesEtudiant.stream()
                .anyMatch(p -> {
                    if (p.getHeurePointage() == null) return false;
                    LocalTime heureP = p.getHeurePointage();
                    return !heureP.isBefore(debutIntervalle2) && !heureP.isAfter(finIntervalle2);
                });



        // Vérifier si l'étudiant a déjà pointé dans cet intervalle
        if ((estDansIntervalle1 && aPointeIntervalle1) || (estDansIntervalle2 && aPointeIntervalle2)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("⚠️ Vous avez déjà pointé dans cet intervalle.");
        }

        Optional<Pointage> pointageOpt = pointagesEtudiant.stream()
                .filter(p -> p.getHeurePointage() == null)
                .filter(p -> {
                    if (estDansIntervalle1) {
                        return p.getHeureDb() == null || p.getHeureDb().equals(debutIntervalle1);
                    } else if (estDansIntervalle2) {
                        return p.getHeureDb() == null || p.getHeureDb().equals(debutIntervalle2);
                    }
                    return false;
                })
                .findFirst();

        if (pointageOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun pointage prévu pour cet intervalle.");
        }

        Pointage pointage = pointageOpt.get();
        pointage.setEtudiant(etudiant.getId());
        pointage.setUtilisateur(etudiantScanDto.getUtilisateurId());
        pointage.setHeurePointage(nowTime);

        if (dureeSeance.toHours() <= 2 || estDansIntervalle1) {
            pointage.setHeureDb(debutIntervalle1);
            pointage.setHeureFin(finIntervalle1);
            pointage.setPointer(Pointer.Present);
        } else if (estDansIntervalle2) {
            pointage.setHeureDb(debutIntervalle2);
            pointage.setHeureFin(finIntervalle2);
            if (aPointeIntervalle1) {
                pointage.setPointer(Pointer.Present);
            }
//            else {
//                pointage.setPointer(Pointer.Retard);
//            }
        }
        pointageService.save(pointage);



        String nomClasse = null;
            if (etudiant.getClasseId() != null) {
                Classe classe = classeService.getClasse(etudiant.getClasseId());
                if (classe != null) {
                    nomClasse = classe.getName();
                }
            }
            var qrcodeEtudiantDto = EtudiantMapper.toQRcodeEtudiantDto(etudiant, nomClasse);
            Map<String, Object> response = RestResponseSecurity.response(
                    HttpStatus.OK,
                    qrcodeEtudiantDto,
                    "QRcodeEtudiantDto"
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
