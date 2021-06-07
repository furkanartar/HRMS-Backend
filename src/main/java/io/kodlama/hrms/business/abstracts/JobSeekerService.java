package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobSeekerService {
    List<JobSeeker> getAll();
    boolean add(JobSeeker jobSeeker);
    List<JobSeeker> findByEmail(String email);
    List<JobSeeker> findByNationalIdentity(String nationalIdentity);
}
