package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.AbsenceRepository;
import ism.atelier.atelier.data.repository.JustificationRepository;
import ism.atelier.atelier.mobile.dto.request.JustificationRequestDto;
import ism.atelier.atelier.mobile.dto.response.JustificationResponseDto;
import ism.atelier.atelier.services.JustificationService;
import ism.atelier.atelier.utils.mappers.JustificationMapper;
import ism.atelier.atelier.web.dto.request.JustificationWebRequestDto;
import ism.atelier.atelier.web.dto.response.JustificationListWebDto;
import ism.atelier.atelier.web.dto.response.JustificationWebResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JustificationServiceImpl implements JustificationService {

    private final JustificationRepository justificationRepository;
    private final AbsenceRepository absenceRepository;
    private final JustificationMapper justificationMapper;


    private String saveFile(MultipartFile file) {
        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get("uploads").resolve(filename);

            // Crée le dossier s'il n'existe pas
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            Files.copy(file.getInputStream(), path);
            return "/uploads/" + filename;
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement du fichier", e);
        }
    }

    @Override
    public JustificationResponseDto creerJustification(String absenceId, JustificationRequestDto dto) {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new RuntimeException("Absence introuvable"));

        String fileUrl = null;
        if (dto.getPieceJointe() != null && !dto.getPieceJointe().isEmpty()) {
            fileUrl = saveFile(dto.getPieceJointe());
        }

        Justification justification = justificationMapper.toEntity(dto, absence, fileUrl);
        justification = justificationRepository.save(justification);

        absence.setJustification(justification);
        absence.setEtat("EN_ATTENTE");
        absenceRepository.save(absence);

        return justificationMapper.toDTO(justification);


    }

    @Override
    public JustificationWebResponseDto  validerJustification(JustificationWebRequestDto dto) {
        Optional<Justification> optionalJustification = justificationRepository.findById(dto.getJustificationId());

        if (optionalJustification.isEmpty()) {
            throw new RuntimeException("Justification non trouvée");
        }

        Justification justification = optionalJustification.get();

        String decision = dto.getDecision();
        if (decision == null) {
            throw new RuntimeException("Décision manquante");
        }

        switch (decision.toUpperCase()) {
            case "VALIDER":
                justification.setEnumJustification(EnumJustification.VALIDE);
                break;
            case "REFUSER":
                justification.setEnumJustification(EnumJustification.REJETER);
                break;
            default:
                throw new RuntimeException("Décision : " + decision);
        }

        justificationRepository.save(justification);

        return justificationMapper.toWebResponse(justification);
    }

    @Override
    public List<JustificationListWebDto> listerJustificationsWeb() {
        List<Justification> justifications = justificationRepository.findAll();
        return justifications.stream()
                .map(justificationMapper::toListWebResponse)
                .collect(Collectors.toList());
    }
}
