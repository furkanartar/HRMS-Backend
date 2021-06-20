package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    List<JobSeeker> findByEmail(String email);
    List<JobSeeker> findByNationalIdentity(String nationalIdentity);
    JobSeeker getById(int id);
}
