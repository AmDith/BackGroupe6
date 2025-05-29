package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.web.dto.request.UtilisateurConneteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

//    UtilisateurConneteDto toDto(Utilisateur utilisateur);
    Utilisateur toEntity(UtilisateurConneteDto categorieDto);

}
