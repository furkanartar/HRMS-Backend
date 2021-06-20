package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.*;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    Result add(Language language);
}