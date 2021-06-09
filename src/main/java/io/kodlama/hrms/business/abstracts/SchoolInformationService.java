package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.SchoolInformation;

import java.util.List;

public interface SchoolInformationService {
    List<SchoolInformation> getAll();
    boolean add(SchoolInformation schoolInformation);
}
