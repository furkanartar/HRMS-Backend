package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisement> getAll();
}
