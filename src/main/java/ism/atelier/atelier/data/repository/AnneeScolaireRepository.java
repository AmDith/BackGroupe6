package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.AnneeScolaire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnneeScolaireRepository extends MongoRepository<AnneeScolaire, Long> {
}
