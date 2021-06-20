package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    DataResult<List<Experience>> getAll();
    Result add(Experience experience);
}
