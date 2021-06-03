package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/employers"})
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping({"/getall"})
    public List<Employer> getAll() {
        return this.employerService.getAll();
    }
}