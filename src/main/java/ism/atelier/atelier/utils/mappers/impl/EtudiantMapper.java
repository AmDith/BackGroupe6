package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    @Mapping(target = "matriculeE", source = "matricule")
    Etudiant toEntity(EtudiantScanDto dto);

    @Mapping(target = "matricule", source = "matriculeE")
    EtudiantScanDto toDto(Etudiant etudiant);
}

