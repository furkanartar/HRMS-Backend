package io.kodlama.hrms.api;

import io.kodlama.hrms.business.abstracts.SkillService;
import io.kodlama.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
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
