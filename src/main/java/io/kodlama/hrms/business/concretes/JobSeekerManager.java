package io.kodlama.hrms.business.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.core.utilities.adapter.MernisService;
import io.kodlama.hrms.dataAccess.abstracts.JobSeekerDao;
import io.kodlama.hrms.entities.concretes.JobSeeker;
import io.kodlama.hrms.entities.dtos.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private MernisService mernisService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisService mernisService) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.mernisService = mernisService;
    }

    @Override
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }

    @Override
    public boolean add(JobSeeker jobSeeker) {
        if (!mernisService.checkIfRealPerson(jobSeeker))
        {
            System.out.println("Lütfen bilgilerinizi kontrol ediniz.");
            return false;
        }

        if (findByEmail(jobSeeker.getEmail()).size() >= 1)
        {
            System.out.println("Email zaten kullanılıyor.");
            return false;
        }

        if (findByEmail(jobSeeker.getNationalIdentity()).size() >= 1)
        {
            System.out.println("TC zaten kullanılıyor.");
            return false;
        }


        this.jobSeekerDao.save(jobSeeker);
        return true;
    }

    @Override
    public List<JobSeeker> findByEmail(String email) {
        return this.jobSeekerDao.findByEmail(email);
    }

    @Override
    public List<JobSeeker> findByNationalIdentity(String nationalIdentity) {
        return this.jobSeekerDao.findByNationalIdentity(nationalIdentity);
    }

    @Override
    public JobSeeker getById(int id) {
        return this.jobSeekerDao.getById(id);
    }

    @Override
    public ResumeDto getJobSeekerResumeById(int id) {
        ResumeDto resumeDto = new ResumeDto();
        JobSeeker jobSeeker = this.jobSeekerDao.getById(id);
        resumeDto.setExperience(jobSeeker.getExperiences());
        resumeDto.setImages(jobSeeker.getImages());
        resumeDto.setLanguages(jobSeeker.getLanguages());
        resumeDto.setSkills(jobSeeker.getSkills());
        resumeDto.setSchoolInformations(jobSeeker.getSchoolInformations());
        resumeDto.setSocialMedias(jobSeeker.getSocialMedias());
        return resumeDto;
    }


}