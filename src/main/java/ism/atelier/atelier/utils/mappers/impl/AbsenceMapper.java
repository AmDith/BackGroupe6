package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;

public class AbsenceMapper {
    public static Absence toEntity(JustificationAbsentDto justificationDto,
                                   String justification, String pointageId) {
        Absence absence = new Absence();
        absence.setPointageId(pointageId);
        absence.setJustificationId(justification);
        return absence;
    }
}
