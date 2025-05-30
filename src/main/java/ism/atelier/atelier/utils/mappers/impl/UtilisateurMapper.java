package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.Classe;
import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import ism.atelier.atelier.security.dto.response.EtudiantResponseDto;
import ism.atelier.atelier.security.dto.response.UtilisateurResponseDto;

public class UtilisateurMapper {
    public static Utilisateur toEntity(UtilisateurConneteDto dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(dto.getLogin());
        utilisateur.setPassword(dto.getPassword());

        return utilisateur;
    }

    public static UtilisateurResponseDto toUtilisateurResponseDto(Utilisateur utilisateur) {
        return UtilisateurResponseDto.builder()
                .id(utilisateur.getId() != null ? Long.valueOf(utilisateur.getId()) : null)
                .nomUtilisateur(utilisateur.getLogin())
                .build();
    }

    public static EtudiantResponseDto toEtudiantResponseDto(Utilisateur utilisateur, String nomClasse) {
        return EtudiantResponseDto.builder()
                .id(utilisateur.getEtudiant().getId())
                .matriculeE(utilisateur.getEtudiant().getMatriculeE())
                .nomComplet(utilisateur.getEtudiant().getNomComple())
                .nomClasse(nomClasse)
                .build();
    }


}
