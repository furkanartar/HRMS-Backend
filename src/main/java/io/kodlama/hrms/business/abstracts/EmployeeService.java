package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    boolean add(Employee employee);
}
