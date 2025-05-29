package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepository extends MongoRepository<Module, Long> {
}
