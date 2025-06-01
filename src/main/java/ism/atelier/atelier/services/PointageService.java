package ism.atelier.atelier.services;


import ism.atelier.atelier.data.models.Pointage;

import java.util.List;

public interface PointageService {
    List<Pointage> getPointagesBySeance(String seanceId);
    Pointage save(Pointage pointage);
    Pointage getById(String id);
}
