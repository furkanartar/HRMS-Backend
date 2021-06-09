package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.utilities.dataAccess.UserDao;
import io.kodlama.hrms.core.utilities.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }

    @Override
    public User getByEmail(String email) {
        return userDao.findByEmail(email);
    }
}