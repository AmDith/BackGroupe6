package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Classe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClasseRepository extends MongoRepository<Classe, String> {
}
