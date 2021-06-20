package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import io.kodlama.hrms.entities.dtos.ResumeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobSeekerService {
    DataResult<List<JobSeeker>>  getAll();
    Result add(JobSeeker jobSeeker);
    DataResult<List<JobSeeker>>  findByEmail(String email);
    DataResult<List<JobSeeker>>  findByNationalIdentity(String nationalIdentity);
    DataResult<JobSeeker> getById(int id);
    DataResult<ResumeDto> getJobSeekerResumeById(int id);
}
