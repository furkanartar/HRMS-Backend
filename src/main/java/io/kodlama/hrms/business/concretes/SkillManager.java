package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.SkillService;
import io.kodlama.hrms.dataAccess.abstracts.SkillDao;
import io.kodlama.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {
    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }


    @Override
    public List<Skill> getAll() {
        return this.skillDao.findAll();
    }

    @Override
    public boolean add(Skill skill) {
        this.skillDao.save(skill);
        return true;
    }
}
