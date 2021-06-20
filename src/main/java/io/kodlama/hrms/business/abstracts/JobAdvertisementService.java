package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.JobAdvertisementsDto;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>>  getAll();
    Result add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisementsDto>>  getAllByActive();
    DataResult<List<JobAdvertisementsDto>>  getAllByActiveAndOrderByCreatedAt();
    DataResult<List<JobAdvertisementsDto>>  getAllByActiveAndEmployerId(int id);
    DataResult<List<JobAdvertisementsDto>>  getAllByJobPositionId(int id);

    Result closeJobAdvertisment(int jobAdvertismentId);
}
