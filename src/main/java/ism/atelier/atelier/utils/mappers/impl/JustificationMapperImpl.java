package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Cours;
import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.mobile.dto.request.JustificationRequestDto;
import ism.atelier.atelier.mobile.dto.response.JustificationResponseDto;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.dto.request.JustificationWebRequestDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import ism.atelier.atelier.web.dto.response.JustificationWebResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Mapper
public class JustificationMapperImpl implements JustificationMapper {

    @Override
    public JustificationListWebDto toListWebDto(Absence absence, Justification justification) {
        return null;
    }

        public Justification toEntity(JustificationRequestDto dto, Absence absence, String fileUrl) {
            Justification justification = new Justification();
            justification.setTitre(dto.getTitre());
            justification.setMotif(dto.getMotif());
            justification.setUrlPieceJointe(fileUrl);
            justification.setAbsence(absence);
            return justification;
        }

    public JustificationResponseDto toDTO(Justification justification) {
        if (justification == null) return null;

        return JustificationResponseDto.builder()
                .id(justification.getId())
                .titre(justification.getTitre())
                .motif(justification.getMotif())
                .urlPieceJointe(justification.getUrlPieceJointe())
                .absenceId(justification.getAbsence() != null ? justification.getAbsence().getId() : null)
                .build();
    }

    @Override
    public JustificationWebResponseDto toWebResponse(Justification justification) {
        return JustificationWebResponseDto.builder()
                .id(justification.getId())
                .titre(justification.getTitre())
                .motif(justification.getMotif())
                .urlPieceJointe(justification.getUrlPieceJointe())
                .absenceId(justification.getAbsence() != null ? justification.getAbsence().getId() : null)
                .etat(justification.getEnumJustification() != null ? justification.getEnumJustification().name() : null)
                .build();
    }

    @Override
    public Justification fromWebRequest(JustificationWebRequestDto dto) {
        return null;
    }

    @Override
    public JustificationListWebDto toListWebResponse(Justification justification) {
        Absence absence = justification.getAbsence();
        Etudiant etudiant = absence.getEtudiant();
        Cours cours = absence.getCours();

        return JustificationListWebDto.builder()
                .nomComplet(etudiant.getNomComple())
                .matricule(etudiant.getMatriculeE())
                .classe(etudiant.getClasse().getNiveauId())
                .date(absence.getDate().toString())
                .cours(cours.getClasseId())
                .etat(justification.getEnumJustification() != null ? justification.getEnumJustification().name() : "EN ATTENTE")
                .build();
    }


//    @Override
////    public JustificationListWebDto toListWebDto(Absence absence, Justification justification) {
////        if (absence == null || justification == null) {
////            return null;
////        }
////
////        JustificationListWebDto dto = new JustificationListWebDto();
////        dto.setJustificationId(justification.getId());
////        dto.setJustificationdate(LocalDate.now().toString());
////        dto.setJustificationmatricule("MAT001");
////        dto.setJustificationnomClasse("L1IAGE");
////        dto.setJustificationnomEtudiant("Amini bobo");
////        dto.setJustificationnomModule("Java");
////
////        return dto;
////    }
//
//    @Override
//    public Justification toEntity(Justification justification) {
//        Justification entity = new Justification();
//        entity.setId(justification.getId());
//        entity.setTitre(justification.getTitre());
//        entity.setMotif(justification.getMotif());
//        entity.setPieceJointe(justification.getPieceJointe());
//        return entity;
//    }
}
