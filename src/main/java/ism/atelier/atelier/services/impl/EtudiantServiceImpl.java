package ism.atelier.atelier.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ism.atelier.atelier.data.repository.EtudiantRepository;
import ism.atelier.atelier.services.EtudiantService;
import ism.atelier.atelier.services.AbsenceWebDto;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public List<ism.atelier.atelier.services.AbsenceWebDto> getAbsencesEtudiantConnecte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAbsencesEtudiantConnecte'");
    }

    // @Override
    // public List<AbsenceWebDto> getAbsencesEtudiantConnecte() {

    //     Etudiant etudiant = SecurityUtils.getEtudiantConnecte();

    //     if (etudiant == null) {
    //         throw new IllegalStateException("Aucun étudiant connecté");
    //     }

    //     List<Absence> absences = absenceRepository.findByEtudiant(etudiant);

    //     return absences.stream()
    //             .map(abs -> AbsenceWebDto.builder()
    //                     .nomComplet(etudiant.getPrenom() + " " + etudiant.getNom())
    //                     .matricule(etudiant.getMatricule())
    //                     .classe(etudiant.getClasse().getNom())
    //                     .date(abs.getDate())
    //                     .matiere(abs.getSeance().getMatiere().getNom())
    //                     .statut(abs.getStatut().name())
    //                     .build()
    //             )
    //             .collect(Collectors.toList());
    // }
}