package ism.atelier.atelier.utils.mappers.impl;

import ism.atelier.atelier.data.models.Etudiant;
import ism.atelier.atelier.mobile.dto.response.QRcodeEtudiantDto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EtudiantMapper {

    public static QRcodeEtudiantDto toQRcodeEtudiantDto(Etudiant etudiant, String nomClasse) {
        String heureScan = LocalTime.now().format(DateTimeFormatter.ofPattern("HH'H'mm"));

        return QRcodeEtudiantDto.builder()
                .date(heureScan)
                .nomComplet(etudiant.getNomComple())
                .nomClasse(nomClasse)
                .mensualate(etudiant.getMensualite())
                .build();
    }
}
