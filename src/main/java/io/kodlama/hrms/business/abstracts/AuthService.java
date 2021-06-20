package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;

public interface AuthService {
    Result registerEmployer(Employer employer, String confirmPassword);
    Result registerJobSeeker(JobSeeker jobSeeker ,String confirmPassword);
}
