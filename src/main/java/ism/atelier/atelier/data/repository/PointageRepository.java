package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Pointage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PointageRepository extends MongoRepository<Pointage, String> {
    List<Pointage> findBySeanceCours(String seanceCoursId);
}
