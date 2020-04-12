package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@BasePathAwareController
@RequestMapping("/single-table")
public class SingleTableInheritanceApi {

    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;

    public SingleTableInheritanceApi(EmployeeRepository employeeRepository, ManagerRepository managerRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public String singleTableInheritance() {

        Employee employee = new Employee();
        employee.setDepartment("IT");
        employee.setFirstName("Employee1 Firstname");
        employee.setLastName("Employee1 Lastname");
        employee.setEmail("employee1@email.com");

        Employee employee2 = new Employee();
        employee2.setDepartment("DevOps");
        employee2.setFirstName("Employee2 Firstname");
        employee2.setLastName("Employee2 Lastname");
        employee2.setEmail("employee2@email.com");

        Manager manager = new Manager();
        manager.setProject("Rest Api");
        manager.setFirstName("Manager1 Firstname");
        manager.setLastName("Manager1 Lastname");
        manager.setEmail("manager1@email.com");

        Manager manager2 = new Manager();
        manager2.setProject("SSR");
        manager2.setFirstName("Manager2 Firstname");
        manager2.setLastName("Manager2 Lastname");
        manager2.setEmail("manager2@email.com");

        employeeRepository.save(employee);
        employeeRepository.save(employee2);

        managerRepository.save(manager);
        managerRepository.save(manager2);

        return "single-table inheritance created";
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<User> all = userRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<User> byId = userRepository.findById(Long.parseLong(id));
        return new ResponseEntity(byId.get(), HttpStatus.FOUND);
    }

    @GetMapping("/employee")
    public ResponseEntity findAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/manager")
    public ResponseEntity findAllManager() {
        List<Manager> all = managerRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

}
