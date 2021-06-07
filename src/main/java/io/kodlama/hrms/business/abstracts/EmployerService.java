package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    boolean add(Employer employer);
    List<Employer> findByEmail(String email);
}
