package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.enums.EnumJustification;
import ism.atelier.atelier.data.models.Justification;
import ism.atelier.atelier.data.repository.JustificationRepository;
import ism.atelier.atelier.mobile.dto.request.JustificationAbsentDto;
import ism.atelier.atelier.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JustificationServiceImpl implements JustificationService {
    private final JustificationRepository justificationRepository;

//    @Override
//    public Justification valider(String id, String statut) {
//        Justification justification =  getJustificationById(id);
//        EnumJustification enumJustification;
//        try {
//            enumJustification = EnumJustification.valueOf(statut);
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Statut invalide");
//        }
//        justification.setEnumJustification(enumJustification);
//        return justificationRepository.save(justification);
//    }

    @Override
    public Justification valider(Long id, String statut) {
        return null;
    }

    @Override
    public Justification ajouterJustification(JustificationAbsentDto justificationDto) {
        Justification justification = new Justification();
        justification.setId(justificationDto.getPointageId().toString());
        justification.setMotifs(justificationDto.getMotifs());
        justification.setTitre(justificationDto.getTitre());
        justification.setPieceJointe(justificationDto.getPieceJointe());
        justification.setEnumJustification(EnumJustification.valueOf(""));

        return justificationRepository.save(justification);
    }

    @Override
    public Justification getJustificationById(Long id) {

        return justificationRepository.findById(id).orElse(null);
    }


    @Override
    public Justification getJustificationsByEtudiant(Long etudiantId) {

        return justificationRepository.findByEtudiantId(etudiantId);
    }

    @Override
    public List<Justification> getAllJustifications() {

        return justificationRepository.findAll();
    }

    @Override
    public void supprimerJustification(String id) {

        justificationRepository.deleteById(id);
    }

    @Override
    public Justification save(Justification justification) {
        return justificationRepository.save(justification);
    }
}
