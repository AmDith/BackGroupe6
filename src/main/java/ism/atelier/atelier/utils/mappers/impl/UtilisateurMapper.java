package ism.atelier.atelier.utils.mappers.impl;


import ism.atelier.atelier.data.models.*;
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

        public static UtilisateurResponseDto toUtilisateurResponseDto(Utilisateur utilisateur, Role role) {
            return UtilisateurResponseDto.builder()
                    .id(utilisateur.getId())
                    .nomUtilisateur(utilisateur.getLogin())
                    .nomRole(role != null ? role.getName() : null)
                    .image("default.jpg")
                    .build();
        }

        public static EtudiantResponseDto toEtudiantResponseDto(Utilisateur utilisateur, Etudiant etudiant, String nomClasse) {
            return EtudiantResponseDto.builder()
                    .id(etudiant.getId())
                    .matriculeE(etudiant.getMatriculeE())
                    .nomComplet(etudiant.getNomComple())
                    .nomClasse(nomClasse)
                    .roleId(utilisateur.getRoleId())
                    .image("default.jpg")
                    .build();
        }

    }



