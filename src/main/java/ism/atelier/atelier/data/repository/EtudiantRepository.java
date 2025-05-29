package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;

public interface EtudiantRepository extends MongoRepository<Etudiant, String> {
    @NonNull
    Etudiant findByMatriculeE(@NonNull String matricule);
}
