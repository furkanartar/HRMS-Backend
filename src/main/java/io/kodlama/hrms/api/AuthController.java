package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.AuthService;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/registerEmployer")
    public boolean registerEmployer(@RequestBody Employer employer, String confirmPassword) {
        System.out.println(employer + " " + confirmPassword);
        return this.authService.registerEmployer(employer, confirmPassword);
    }

    @PostMapping("/registerJobSeeker")
    public boolean registerJobSeeker(@RequestBody JobSeeker jobSeeker, String confirmPassword) {
        System.out.println(jobSeeker + " " + confirmPassword);
        return this.authService.registerJobSeeker (jobSeeker, confirmPassword);
    }
}
