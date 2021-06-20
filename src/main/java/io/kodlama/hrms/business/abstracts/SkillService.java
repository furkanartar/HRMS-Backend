package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    DataResult<List<Skill>> getAll();
    Result add(Skill skill);
}
