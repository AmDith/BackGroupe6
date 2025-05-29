package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EtudiantMapper {
    EtudiantMapper INSTANCE = Mappers.getMapper(EtudiantMapper.class);

    Etudiant toEntity(EtudiantScanDto etudiantScanDto);
}
