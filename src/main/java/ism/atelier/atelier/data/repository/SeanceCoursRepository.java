package ism.atelier.atelier.data.repository;

import ism.atelier.atelier.data.models.Pointage;
import ism.atelier.atelier.data.models.SeanceCours;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SeanceCoursRepository extends MongoRepository<SeanceCours, String> {
    List<SeanceCours> findByDate(LocalDate date);
    List<Pointage> getAllById(String id);

    @Query("{ 'date': { $gte: ?0, $lt: ?1 } }")
    List<SeanceCours> findByDateBetween(LocalDateTime start, LocalDateTime end);

}
