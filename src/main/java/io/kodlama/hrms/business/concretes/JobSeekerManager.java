package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.JobSeekerService;
import io.kodlama.hrms.core.utilities.adapter.MernisService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
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
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayan bilgileri getirildi.");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!mernisService.checkIfRealPerson(jobSeeker))
        {
            return new SuccessResult("Lütfen bilgilerinizi kontrol ediniz.");
        }

        if (findByEmail(jobSeeker.getEmail()).getData().size() >= 1)
        {
            return new SuccessResult("Email zaten kullanılıyor.");
        }

        if (findByEmail(jobSeeker.getNationalIdentity()).getData().size() >= 1)
        {
            return new SuccessResult("Kimlik numarası zaten kullanılıyor.");
        }

        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Kaydınız başarıyla gerçekleştirildi..");
    }

    @Override
    public DataResult<List<JobSeeker>> findByEmail(String email) {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findByEmail(email), "Email adresine göre getirildi.");
    }

    @Override
    public DataResult<List<JobSeeker>> findByNationalIdentity(String nationalIdentity) {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findByNationalIdentity(nationalIdentity), "Kimlik bilgisine göre getirildi.");
    }

    @Override
    public DataResult<JobSeeker> getById(int id) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id), "İd'ye göre listelendi.");
    }

    @Override
    public SuccessDataResult<ResumeDto> getJobSeekerResumeById(int id) {
        ResumeDto resumeDto = new ResumeDto();
        JobSeeker jobSeeker = this.jobSeekerDao.getById(id);
        resumeDto.setExperience(jobSeeker.getExperiences());
        resumeDto.setImages(jobSeeker.getImages());
        resumeDto.setLanguages(jobSeeker.getLanguages());
        resumeDto.setSkills(jobSeeker.getSkills());
        resumeDto.setSchoolInformations(jobSeeker.getSchoolInformations());
        resumeDto.setSocialMedias(jobSeeker.getSocialMedias());
        return new SuccessDataResult<ResumeDto>(resumeDto, "CV getirildi.");
    }
}