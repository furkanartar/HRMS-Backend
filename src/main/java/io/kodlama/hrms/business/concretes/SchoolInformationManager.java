package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.SchoolInformationService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.SchoolInformationDao;
import io.kodlama.hrms.dataAccess.abstracts.SchoolInformationDao;
import io.kodlama.hrms.entities.concretes.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskHolder;
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
    public DataResult<List<SchoolInformation>> getAll() {
        return new SuccessDataResult<List<SchoolInformation>>(this.schoolInformationDao.findAll(), "Okul bilgileri başarıyla getirildi.");
    }

    @Override
    public Result add(SchoolInformation schoolInformation) {
        this.schoolInformationDao.save(schoolInformation);
        return new SuccessResult("Okul bilgisi başarıyla eklendi.");
    }
}
