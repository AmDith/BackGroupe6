package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
}
