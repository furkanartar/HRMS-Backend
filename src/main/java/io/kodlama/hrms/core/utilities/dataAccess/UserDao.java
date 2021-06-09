package io.kodlama.hrms.core.utilities.dataAccess;

import io.kodlama.hrms.core.utilities.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}