package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.SkillService;
import io.kodlama.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {
    private SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/getAll")
    public List<Skill> getAll() {
        return this.skillService.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Skill skill) {
        return this.skillService.add(skill);
    }
}
