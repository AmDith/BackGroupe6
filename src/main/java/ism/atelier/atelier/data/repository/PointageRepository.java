package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Pointage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PointageRepository extends MongoRepository<Pointage, Long> {
}
