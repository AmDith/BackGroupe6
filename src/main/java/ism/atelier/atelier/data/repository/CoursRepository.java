package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Cours;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoursRepository extends MongoRepository<Cours, Long> {
}
