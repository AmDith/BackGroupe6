package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Justification;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JustificationRepository extends MongoRepository<Justification, String> {
}
