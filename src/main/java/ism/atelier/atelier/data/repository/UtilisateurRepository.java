package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, Long> {
    Utilisateur getById(Long id);
}
