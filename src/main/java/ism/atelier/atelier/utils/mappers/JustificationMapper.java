package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.mobile.dto.request.JustificationRequestDto;
import ism.atelier.atelier.mobile.dto.response.JustificationResponseDto;
import ism.atelier.atelier.web.dto.request.JustificationWebRequestDto;
import ism.atelier.atelier.web.dto.request.ValiderJustificationDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import ism.atelier.atelier.web.dto.response.JustificationWebResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface JustificationMapper {
    JustificationMapper INSTANCE = Mappers.getMapper(JustificationMapper.class);

   public JustificationListWebDto toListWebDto(Absence absence, Justification justification);
   Justification toEntity(JustificationRequestDto dto, Absence absence, String fileUrl);
    JustificationResponseDto toDTO(Justification entity);
    JustificationWebResponseDto toWebResponse(Justification justification);

    Justification fromWebRequest(JustificationWebRequestDto dto);
    JustificationListWebDto toListWebResponse(Justification justification);
}
