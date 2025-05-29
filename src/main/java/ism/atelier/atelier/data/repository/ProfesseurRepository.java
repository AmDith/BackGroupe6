package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Professeur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfesseurRepository extends MongoRepository<Professeur, String> {
}
