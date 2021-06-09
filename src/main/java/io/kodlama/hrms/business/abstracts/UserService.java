package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getByEmail(String email);
}