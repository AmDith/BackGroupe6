package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EtudiantRepository extends MongoRepository<Etudiant, Long> {
}
