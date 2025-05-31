package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Absence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbsenceRepository extends MongoRepository<Absence, Long> {
    
}
