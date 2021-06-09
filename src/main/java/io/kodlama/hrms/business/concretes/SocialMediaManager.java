package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.SocialMediaService;
import io.kodlama.hrms.dataAccess.abstracts.SocialMediaDao;
import io.kodlama.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocialMediaManager implements SocialMediaService {
    private SocialMediaDao socialMediaDao;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        this.socialMediaDao = socialMediaDao;
    }

    @Override
    public List<SocialMedia> getAll() {
        return this.socialMediaDao.findAll();
    }

    @Override
    public boolean add(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return true;
    }
}
