package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.ExperienceService;
import io.kodlama.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {
    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/getAll")
    public List<Experience> getAll() {
        return this.experienceService.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Experience experience) {
        return this.experienceService.add(experience);
    }
}
