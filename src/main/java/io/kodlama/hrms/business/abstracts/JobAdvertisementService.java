package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsByCompanyDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsOrderByCreatedAt;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisement> getAll();
    boolean add(JobAdvertisement jobAdvertisement);

    List<ActiveJobAdvertisementsDto> getAllByActive();
    List<ActiveJobAdvertisementsOrderByCreatedAt> getAllByActiveAndOrderByCreatedAt();
    List<ActiveJobAdvertisementsByCompanyDto> getAllByActiveAndEmployerId(int id);

    boolean closeJobAdvertisment(int jobAdvertismentId);
}
