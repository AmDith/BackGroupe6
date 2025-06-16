package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.mobile.dto.request.JustificationRequestDto;
import ism.atelier.atelier.mobile.dto.response.JustificationResponseDto;
import ism.atelier.atelier.web.dto.request.JustificationWebRequestDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import ism.atelier.atelier.web.dto.response.JustificationWebResponseDto;

import java.util.List;

public interface JustificationService {
    JustificationResponseDto creerJustification(String absenceId, JustificationRequestDto dto);
    JustificationWebResponseDto  validerJustification(JustificationWebRequestDto dto);
    List<JustificationListWebDto> listerJustificationsWeb();
//    List<Justification> listerJustification();
//    Justification validerJustification(String id, String statut);
//    Justification ajouterJustification(JustificationAbsentDto justificationDto);
//    Justification getJustificationById(String id);
//    List<Justification> getAllJustifications();
//    Justification save(Justification justification);
//    List<Justification> findAll();

}
