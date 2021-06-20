package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.WayOfWorkingService;
import io.kodlama.hrms.dataAccess.abstracts.WayOfWorkingDao;
import io.kodlama.hrms.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {
    WayOfWorkingDao wayOfWorkingDao;

    @Autowired
    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
        this.wayOfWorkingDao = wayOfWorkingDao;
    }

    @Override
    public List<WayOfWorking> getAll() {
        return this.wayOfWorkingDao.findAll();
    }
}
