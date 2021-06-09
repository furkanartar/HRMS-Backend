package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.JobSeeker;
import io.kodlama.hrms.entities.dtos.ResumeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobSeekerService {
    List<JobSeeker> getAll();
    boolean add(JobSeeker jobSeeker);
    List<JobSeeker> findByEmail(String email);
    List<JobSeeker> findByNationalIdentity(String nationalIdentity);
    JobSeeker getById(int id);
    ResumeDto getJobSeekerResumeById(int id);
}
