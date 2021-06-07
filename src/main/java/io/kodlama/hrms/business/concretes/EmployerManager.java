package io.kodlama.hrms.business.concretes;

import com.sun.tools.jconsole.JConsoleContext;
import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.dataAccess.abstracts.EmployerDao;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return this.employerDao.findAll();
    }

    @Override
    public boolean add(Employer employer) {

        if (employer.getEmail().isEmpty() || employer.getWebSite().isEmpty())
        {
            System.out.println("Email'i ve Web site'yi kontrol ediniz.");
            return false;
        }

        if (findByEmail(employer.getEmail()).size() >= 1) {
            System.out.println("Bu email adresi zaten kullanılıyor.");
            return false;
        }

        this.employerDao.save(employer);
        return true;
        }

        @Override
        public List<Employer> findByEmail (String email){
            return this.employerDao.findByEmail(email);
        }
    }