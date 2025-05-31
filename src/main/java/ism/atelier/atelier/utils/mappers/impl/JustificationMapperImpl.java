package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;

public class JustificationMapperImpl implements JustificationMapper {

    @Override
    public JustificationListWebDto toListWebDto(Absence absence, Justification justification) {
        if (absence == null || justification == null) {
            return null;
        }

        JustificationListWebDto dto = new JustificationListWebDto();
        dto.setAbsenceId(absence.getId());
        dto.setPointageId(absence.getPointageId());
        dto.setStatut(absence.getStatut());
        dto.setTitre(justification.getTitre());
        dto.setMotifs(justification.getMotifs());
        dto.setPieceJointe(justification.getPieceJointe());
        return dto;
    }
}
