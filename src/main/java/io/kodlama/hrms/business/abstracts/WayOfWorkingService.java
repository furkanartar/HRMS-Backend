package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.WayOfWorking;

import java.util.List;

public interface WayOfWorkingService {
    DataResult<List<WayOfWorking>> getAll();
}
