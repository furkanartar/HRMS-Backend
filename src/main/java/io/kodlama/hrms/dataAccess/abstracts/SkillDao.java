package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill, Integer> {
}
