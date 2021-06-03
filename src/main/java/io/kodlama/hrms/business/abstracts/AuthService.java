package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import io.kodlama.hrms.entities.dtos.CancidateForRegisterDto;
import io.kodlama.hrms.entities.dtos.EmployerForRegisterDto;

public interface AuthService {
    boolean registerEmployer(Employer employer,String confirmPassword);
    boolean registerJobSeeker(JobSeeker jobSeeker ,String confirmPassword);
}
