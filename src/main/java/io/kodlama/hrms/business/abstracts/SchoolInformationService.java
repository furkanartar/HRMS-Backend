package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.SchoolInformation;

import java.util.List;

public interface SchoolInformationService {
    DataResult<List<SchoolInformation>> getAll();
    Result add(SchoolInformation schoolInformation);
}
