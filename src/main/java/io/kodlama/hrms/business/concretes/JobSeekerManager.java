package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.dataAccess.abstracts.JobSeekerDao;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }

    @Override
    public boolean add(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return true;
    }
}