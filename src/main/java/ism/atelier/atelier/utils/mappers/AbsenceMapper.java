package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.web.dto.response.AbsenceListDto;
import ism.atelier.atelier.web.dto.response.AbsenceListWebDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AbsenceMapper {
    AbsenceMapper INSTANCE = Mappers.getMapper(AbsenceMapper.class);

//    Absence toEntity(JustificationAbsentDto justificationDto);
    AbsenceListDto toListDto(Absence absence);
    AbsenceListWebDto toListWebDto(Absence absence);
}
