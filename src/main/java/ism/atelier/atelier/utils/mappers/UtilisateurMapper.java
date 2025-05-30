package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import ism.atelier.atelier.security.dto.response.EtudiantResponseDto;
import ism.atelier.atelier.security.dto.response.UtilisateurResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    Utilisateur toEntity(UtilisateurConneteDto utilisateurConneteDto);
    EtudiantResponseDto toEtudiantResponseDto(Utilisateur utilisateur);
    UtilisateurResponseDto toUtilisateurResponseDto(Utilisateur utilisateur);

}
