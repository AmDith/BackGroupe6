package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.SeanceCours;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface SeanceCoursRepository extends MongoRepository<SeanceCours, String> {
    List<SeanceCours> findByDate(LocalDate date);
}
