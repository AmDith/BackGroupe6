package ism.atelier.atelier.web.controllers.impl;

import ism.atelier.atelier.services.AbsenceService;
import ism.atelier.atelier.web.controllers.AbsenceWebController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AbsenceWebControllerImpl implements AbsenceWebController {

    private final AbsenceService absenceService;

    public AbsenceWebControllerImpl(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> listerAbsents() {
        Map<String, Object> data = new HashMap<>();
        data.put("absents", absenceService.listerToutPointageAbscent());
        return ResponseEntity.ok(data);
    }
}
