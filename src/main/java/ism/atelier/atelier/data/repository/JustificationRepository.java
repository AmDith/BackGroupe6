package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Justification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface JustificationRepository extends MongoRepository<Justification, Long> {
        List<Justification> findByEtudiantId(Long etudiantId);

        Long id(String id);
}
