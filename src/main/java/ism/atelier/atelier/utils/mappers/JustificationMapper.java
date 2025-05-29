package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationWebDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JustificationMapper {
    JustificationMapper INSTANCE = Mappers.getMapper(JustificationMapper.class);

    Justification toEntity(ValiderJustificationDto justificationDto);
   JustificationWebDto toListWebDto(Justification justification);
}
