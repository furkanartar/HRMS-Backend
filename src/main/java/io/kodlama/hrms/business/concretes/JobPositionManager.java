package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.JobPositionService;
import io.kodlama.hrms.core.utilities.results.*;
import io.kodlama.hrms.dataAccess.abstracts.JobPositionDao;
import io.kodlama.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "İş pozisyonları getirildi.");
    }

    @Override
    public Result add(JobPosition jobPosition) {

        if ((findByName(jobPosition.getName()).getData().size() >= 1))
        {
            return new ErrorResult("Pozisyon adını kontrol ediniz.");
        }

        jobPositionDao.save(jobPosition);
        return new SuccessResult("İş pozisyonu eklendi.");
    }

    @Override
    public DataResult<List<JobPosition>> findByName(String name) {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findByName(name), "İsme göre iş pozisyonları listelendi.");
    }
}