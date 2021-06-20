package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.AuthService;
import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
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
    public Result registerEmployer(Employer employer, String confirmPassword) {
        var result = this.employerService.add(employer);
        if (result.isSuccess())
        {
            return new SuccessResult("Kayıt başarıyla gerçekleştirildi.");
        }

        return new ErrorResult("Kayıt başarısız");
    }

    @Override
    public Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
        var result= this.jobSeekerService.add(jobSeeker);
        if (result.isSuccess())
        {
            return new SuccessResult("Kayıt başarıyla gerçekleştirildi.");
        }

        return new ErrorResult("Kayıt başarısız");
    }
}