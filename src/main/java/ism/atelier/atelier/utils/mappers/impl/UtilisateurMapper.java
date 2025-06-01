package ism.atelier.atelier.utils.mappers.impl;


import ism.atelier.atelier.data.enums.Pointer;
import ism.atelier.atelier.data.models.*;
import ism.atelier.atelier.data.models.Module;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.data.repository.CoursRepository;
import ism.atelier.atelier.data.repository.ModuleRepository;
import ism.atelier.atelier.data.repository.SeanceCoursRepository;
import ism.atelier.atelier.security.dto.request.UtilisateurConneteDto;
import ism.atelier.atelier.security.dto.response.AbsenceListSecurityDto;
import ism.atelier.atelier.security.dto.response.EtudiantResponseDto;
import ism.atelier.atelier.security.dto.response.UtilisateurResponseDto;


import java.util.ArrayList;
import java.util.List;

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
                .build();
    }

    public static EtudiantResponseDto toEtudiantResponseDto(
            Utilisateur utilisateur,
            Etudiant etudiant,
            String nomClasse,
            List<Pointage> pointages,
            AbsenceRepository absenceRepository,
            SeanceCoursRepository seanceCoursRepository,
            CoursRepository coursRepository,
            ModuleRepository moduleRepository
    ) {
        List<AbsenceListSecurityDto> absenceListDtos = new ArrayList<>();

        for (Pointage pointage : pointages) {
            if (pointage.getPointer() != Pointer.Abscent) continue;

            Absence absence = null;
            if (pointage.getAbsenceId() != null) {
                absence = absenceRepository.findById(pointage.getAbsenceId()).orElse(null);
            }

            SeanceCours seance = seanceCoursRepository.findById(pointage.getSeanceCours()).orElse(null);
            if (seance == null) continue;

            Cours cours = coursRepository.findById(seance.getCoursId()).orElse(null);
            if (cours == null) continue;

            Module module = moduleRepository.findById(cours.getModuleId()).orElse(null);
            if (module == null) continue;


            AbsenceListSecurityDto dto = new AbsenceListSecurityDto();
            dto.setId(absence != null ? absence.getId() : "");
            dto.setDate(seance.getDate());
            dto.setHeureDb(seance.getHeureDb().getHour() + "H");
            dto.setHeureFin(seance.getHeureFin().getHour() + "H");
            dto.setEtatPointage((absence != null && absence.getJustificationId() != null) ? "Justifier" : "NoJustifier");
            dto.setNomModule(module.getName());

            absenceListDtos.add(dto);
        }

        return EtudiantResponseDto.builder()
                .id(etudiant.getId())
                .matriculeE(etudiant.getMatriculeE())
                .nomComplet(etudiant.getNomComple())
                .nomClasse(nomClasse)
                .roleId(utilisateur.getRoleId())
                .absenceListerDtoIds(absenceListDtos)
                .build();
    }




}
