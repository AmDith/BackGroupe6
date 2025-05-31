package ism.atelier.atelier.utils.mappers.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantScanDto {
    private String nom;
    private String prenom;
    private String matricule;
    private String classeId;
}

