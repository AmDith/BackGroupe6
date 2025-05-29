package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.SeanceCours;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceCoursRepository extends MongoRepository<SeanceCours, Long> {
}
