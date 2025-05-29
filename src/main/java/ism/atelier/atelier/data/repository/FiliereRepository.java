package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Filiere;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FiliereRepository extends MongoRepository<Filiere, String> {
}
