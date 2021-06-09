package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getAll();
    boolean add(Skill skill);
}
