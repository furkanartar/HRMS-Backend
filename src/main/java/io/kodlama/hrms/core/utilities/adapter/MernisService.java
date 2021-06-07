package io.kodlama.hrms.core.utilities.adapter;

import io.kodlama.hrms.entities.concretes.JobSeeker;

public interface MernisService {
    boolean checkIfRealPerson(JobSeeker jobSeeker);
}
