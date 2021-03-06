//package io.kodlama.hrms.api;
//
//import io.kodlama.hrms.business.abstracts.EmployeeService;
//import io.kodlama.hrms.entities.concretes.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping({"/api/employees"})
//public class EmployeesController {
//    private EmployeeService employeeService;
//
//    @Autowired
//    public EmployeesController(EmployeeService employeeService) {
//        super();
//        this.employeeService = employeeService;
//    }
//
//    @GetMapping({"/getall"})
//    public List<Employee> getAll() {
//        return this.employeeService.getAll();
//    }
//}