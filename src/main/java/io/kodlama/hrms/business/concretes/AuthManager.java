package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.AuthService;
import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private JobSeekerService jobSeekerService;
    private EmployerService employerService;

    @Autowired
    public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService) {
        super();
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
    }

    @Override
    public boolean registerEmployer(Employer employer, String confirmPassword) {
        return this.employerService.add(employer);
    }

    @Override
    public boolean registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
        return this.jobSeekerService.add(jobSeeker);
    }
}