package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.LanguageService;
import io.kodlama.hrms.dataAccess.abstracts.LanguageDao;
import io.kodlama.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public List<Language> getAll() {
        return this.languageDao.findAll();
    }

    @Override
    public boolean add(Language language) {
        this.languageDao.save(language);
        return true;
    }
}
