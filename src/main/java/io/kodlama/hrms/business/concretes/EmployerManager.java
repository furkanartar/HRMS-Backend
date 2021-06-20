package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.EmployerDao;
import io.kodlama.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Tüm işveren hesapları getirildi.");
    }

    @Override
    public Result add(Employer employer) {
        if (employer.getEmail().isEmpty() || employer.getWebSite().isEmpty())
        {
            return new SuccessResult("Email'i ve Web site'yi kontrol ediniz.");
        }

        if (findByEmail(employer.getEmail()).getData().size() >= 1) {
            return new SuccessResult("Bu email adresi zaten kullanılıyor.");
        }

        this.employerDao.save(employer);
        return new SuccessResult("Hesabınız başarıyla oluşturuldu.");
        }

        @Override
        public DataResult<List<Employer>> findByEmail (String email){
        return new SuccessDataResult<List<Employer>>(this.employerDao.findByEmail(email), "Email adresine göre iş verenler getirildi.");
        }
    }