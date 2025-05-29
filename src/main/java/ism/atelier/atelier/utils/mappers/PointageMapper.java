package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Pointage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PointageMapper {
    PointageMapper INSTANCE = Mappers.getMapper(PointageMapper.class);

    //    UtilisateurConneteDto toDto(Utilisateur utilisateur);
    Pointage toEntity(PointageJustificationAbsentDto pointageDto);
}
