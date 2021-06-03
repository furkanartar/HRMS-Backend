package io.kodlama.hrms.business.concretes;

import io.kodlama.hrms.business.abstracts.EmployeeService;
import io.kodlama.hrms.dataAccess.abstracts.EmployeeDao;
import io.kodlama.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeDao.findAll();
    }

    @Override
    public boolean add(@RequestBody Employee employee) {
        this.employeeDao.save(employee);
        return true;
    }
}