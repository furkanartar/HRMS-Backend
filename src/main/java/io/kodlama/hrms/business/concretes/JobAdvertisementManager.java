package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.JobAdvertisementDao;
import io.kodlama.hrms.entities.concretes.JobAdvertisement;
import io.kodlama.hrms.entities.dtos.JobAdvertisementsDto;
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
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "İş ilanları listelendi.");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı eklendi.");
    }

    @Override
    public DataResult<List<JobAdvertisementsDto>> getAllByActive() {
       return new SuccessDataResult<List<JobAdvertisementsDto>>(this.jobAdvertisementDao.getAllByActive(), "Aktif iş ilanları listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisementsDto>> getAllByActiveAndOrderByCreatedAt() {
        return new SuccessDataResult<List<JobAdvertisementsDto>>(this.jobAdvertisementDao.getAllByActiveAndOrderByCreatedAt(), "Aktif iş ilanları listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisementsDto>> getAllByActiveAndEmployerId(int id) {
        return new SuccessDataResult<List<JobAdvertisementsDto>>(this.jobAdvertisementDao.getAllByActiveAndEmployerId(id), "Aktif iş ilanları listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisementsDto>> getAllByJobPositionId(int id) {
        return new SuccessDataResult<List<JobAdvertisementsDto>>(this.jobAdvertisementDao.getAllByJobPositionId(id), "Aktif iş ilanları listelendi.");
    }

    @Override
    public Result closeJobAdvertisment(int jobAdvertismentId) {

        var jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertismentId);
        jobAdvertisement.get().setActive(false);
        this.jobAdvertisementDao.save(jobAdvertisement.get());

        return new SuccessResult("İş ilanı kapatıldı.");
    }
}
