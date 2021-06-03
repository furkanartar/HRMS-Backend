package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
