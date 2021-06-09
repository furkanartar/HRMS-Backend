package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.SchoolInformationService;
import io.kodlama.hrms.dataAccess.abstracts.SchoolInformationDao;
import io.kodlama.hrms.dataAccess.abstracts.SchoolInformationDao;
import io.kodlama.hrms.entities.concretes.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolInformationManager implements SchoolInformationService {
    public SchoolInformationDao schoolInformationDao;

    @Autowired
    public SchoolInformationManager(SchoolInformationDao schoolInformationDao) {
        this.schoolInformationDao = schoolInformationDao;
    }

    @Override
    public List<SchoolInformation> getAll() {
        return this.schoolInformationDao.findAll();
    }

    @Override
    public boolean add(SchoolInformation schoolInformation) {
        this.schoolInformationDao.save(schoolInformation);
        return true;
    }
}
