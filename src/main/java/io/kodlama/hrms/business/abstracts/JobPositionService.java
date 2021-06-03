package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
    boolean add(JobPosition jobPosition);
    List<JobPosition> findByName(String name);
}
