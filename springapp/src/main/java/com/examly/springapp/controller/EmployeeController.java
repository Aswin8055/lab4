package com.examly.springapp.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @GetMapping("/hired/{hireDate}")
    public ResponseEntity<List<Employee>> getEmployeesByHireDate(@PathVariable String hireDate) {
        List<Employee> employees = employeeService.getEmployeesByHireDate(LocalDate.parse(hireDate));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("/first-three-characters-of-name")
    public ResponseEntity<List<String>> getFirstThreeCharactersOfNames() {
        List<String> names = employeeService.getFirstThreeCharactersOfNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }
} 