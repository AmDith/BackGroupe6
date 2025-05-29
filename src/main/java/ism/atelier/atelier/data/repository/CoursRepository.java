package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Cours;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;

public interface CoursRepository extends MongoRepository<Cours, String> {
    @NonNull
    Cours findByClasseId(@NonNull String classeId);
}
