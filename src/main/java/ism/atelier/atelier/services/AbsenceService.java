package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Absence;

import java.util.List;

public interface AbsenceService {
    List<Absence> listerToutPointageAbscent();
    Absence save(Absence absence);
}
