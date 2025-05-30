package ism.atelier.atelier.utils.mappers;

import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.mobile.dto.request.EtudiantScanDto;
import ism.atelier.atelier.mobile.dto.response.QRcodeEtudiantDto;
import ism.atelier.atelier.security.dto.response.EtudiantResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EtudiantMapper {
    EtudiantMapper INSTANCE = Mappers.getMapper(EtudiantMapper.class);

    Etudiant toEntity(EtudiantScanDto etudiantScanDto);
    QRcodeEtudiantDto toQRcodeEtudiantDto(Etudiant etudiant);
}
