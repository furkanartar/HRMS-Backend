package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.AuthService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/registerEmployer")
    public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
        return this.authService.registerEmployer(employer, confirmPassword);
    }

    @PostMapping("/registerJobSeeker")
    public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker, String confirmPassword) {
        return this.authService.registerJobSeeker (jobSeeker, confirmPassword);
    }
}
