package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JustificationMapper {
    JustificationMapper INSTANCE = Mappers.getMapper(JustificationMapper.class);

   public JustificationListWebDto toListWebDto(Absence absence, Justification justification);
}
