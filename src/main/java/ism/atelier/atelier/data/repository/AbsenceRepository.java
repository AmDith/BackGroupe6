package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Absence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AbsenceRepository extends MongoRepository<Absence, String> {
    Optional<Absence> findByPointageId(String pointageId);
}
