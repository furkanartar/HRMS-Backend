package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    List<Employer> findByEmail(String email);
}
