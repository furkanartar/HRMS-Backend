package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.entities.User;
import io.kodlama.hrms.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
}