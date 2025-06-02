package ism.atelier.atelier.services;

import ism.atelier.atelier.data.models.Absence;
import ism.atelier.atelier.data.models.Module;

public interface ModuleService {
    Module findById(String moduleId);
}
