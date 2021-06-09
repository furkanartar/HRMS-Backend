package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> getAll();
    boolean add(Experience experience);
}
