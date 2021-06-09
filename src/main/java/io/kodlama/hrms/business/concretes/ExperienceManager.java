package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.ExperienceService;
import io.kodlama.hrms.dataAccess.abstracts.ExperienceDao;
import io.kodlama.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {
    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public List<Experience> getAll() {
        return this.experienceDao.findAll();
    }

    @Override
    public boolean add(Experience experience) {
        this.experienceDao.save(experience);
        return true;
    }
}