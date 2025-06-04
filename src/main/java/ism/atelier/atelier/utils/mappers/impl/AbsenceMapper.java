package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.mobile.dto.response.AbsenceListDto;
import ism.atelier.atelier.web.dto.response.AbsenceListWebDto;



public class AbsenceMapper {

        public static AbsenceListDto toAbsenceListDto(
                Absence absence,
                SeanceCours seance,
                Module module
        ) {
            AbsenceListDto dto = new AbsenceListDto();
            dto.setId(absence.getId());
            dto.setDate(seance.getDate());
            dto.setHeureDb(seance.getHeureDb().getHour() + "H");
            dto.setHeureFin(seance.getHeureFin().getHour() + "H");
            dto.setEtatPointage(absence.getJustificationId() != null ? "Justifier" : "NoJustifier");
            dto.setNomModule(module.getName());
            return dto;
        }



    public static AbsenceListWebDto toWebDto(
            Absence absence,
            Etudiant etudiant,
            SeanceCours seance,
            Module module,
            Classe classe
    ) {
        return AbsenceListWebDto.builder()
                .id(absence.getId())
                .date(seance.getDate())
                .nomEtudiant(etudiant.getNomComple())
                .matricule(etudiant.getMatriculeE())
                .nomClasse(classe.getName())
                .nomModule(module.getName())
                .image("default.jpg")
                .etatAbsence(absence.getJustificationId() != null ? "JUSTIFIE" : "NON-JUSTIFIE")
                .build();
    }



}
