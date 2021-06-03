package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    boolean add(Employer employer);
}
