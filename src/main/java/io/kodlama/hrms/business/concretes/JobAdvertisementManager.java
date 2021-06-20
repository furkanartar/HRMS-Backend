package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.dataAccess.abstracts.JobAdvertisementDao;
import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsByCompanyDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsDto;
import io.kodlama.hrms.entities.dtos.ActiveJobAdvertisementsOrderByCreatedAt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public List<JobAdvertisement> getAll() {
        return this.jobAdvertisementDao.findAll();
    }

    @Override
    public boolean add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return true;
    }

    @Override
    public List<ActiveJobAdvertisementsDto> getAllByActive() {
        return this.jobAdvertisementDao.getAllByActive();
    }

    @Override
    public List<ActiveJobAdvertisementsOrderByCreatedAt> getAllByActiveAndOrderByCreatedAt() {
        return this.jobAdvertisementDao.getAllByActiveAndOrderByCreatedAt();
    }

    @Override
    public List<ActiveJobAdvertisementsByCompanyDto> getAllByActiveAndEmployerId(int id) {
        return this.jobAdvertisementDao.getAllByActiveAndEmployerId(id);
    }

    @Override
    public List<JobAdvertisement> findAllByJobPositionId(int id) {
        return this.jobAdvertisementDao.findAllByJobPositionId(id);
    }

    @Override
    public boolean closeJobAdvertisment(int jobAdvertismentId) {

        var jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertismentId);
        jobAdvertisement.get().setActive(false);
        this.jobAdvertisementDao.save(jobAdvertisement.get());

        return true;
    }
}
