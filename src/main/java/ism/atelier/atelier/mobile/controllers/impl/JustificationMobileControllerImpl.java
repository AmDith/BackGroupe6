package ism.atelier.atelier.mobile.controllers.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.controllers.JustificationMobileController;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JustificationMobileControllerImpl implements JustificationMobileController {
    private final JustificationService justificationService;
    @Override
    public ResponseEntity<?> justificatif(JustificationAbsentDto justificationDto,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
//        justificationService.valider(justificationDto)
        return ResponseEntity.ok("Justification validée avec succès");
        
    }

//    @Override
//    public ResponseEntity<?> validerJustification(String id, EnumJustification enumJustification) {
//            Justification justification = justificationService.valider(id, enumJustification.name());
//            return ResponseEntity.ok(justification);
//    }
}
