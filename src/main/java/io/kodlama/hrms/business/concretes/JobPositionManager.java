package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.JobPositionService;
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
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public boolean add(JobPosition jobPosition) {

        if ((findByName(jobPosition.getName()).size() >= 1))
        {return false;}

        jobPositionDao.save(jobPosition);
        return true;
    }

    @Override
    public List<JobPosition> findByName(String name) {
        return jobPositionDao.findByName(name);
    }
}