package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
    Utilisateur getById(Long id);
    Optional<Utilisateur> findByLogin(String login);
    Utilisateur findByPassword(String password);
}
