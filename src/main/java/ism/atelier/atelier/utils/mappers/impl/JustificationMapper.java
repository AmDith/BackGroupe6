package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.web.dto.response.JustificationWebDto;

public class JustificationMapper  {
    public static JustificationWebDto toWebDto(
            Etudiant etudiant,
            SeanceCours seance,
            Module module,
            Classe classe,
            Justification justification
    ) {
        return JustificationWebDto.builder()
                .id(justification.getId())
                .date(seance.getDate())
                .nomEtudiant(etudiant.getNomComple())
                .matricule(etudiant.getMatriculeE())
                .nomClasse(classe.getName())
                .nomModule(module.getName())
                .image(justification.getPieceJointe())
                .statutJustification(justification.getEnumJustification() == EnumJustification.EnCours ? "En Attente" : justification.getEnumJustification().toString())
                .build();
    }
}
