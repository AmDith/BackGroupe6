package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Niveau;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NiveauRepository extends MongoRepository<Niveau, Long> {
}
