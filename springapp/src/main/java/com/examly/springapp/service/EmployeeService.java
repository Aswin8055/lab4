package com.examly.springapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }
    
    public List<Employee> getEmployeesByHireDate(LocalDate hireDate) {
        return employeeRepo.findByHireDate(hireDate);
    }
    
    public List<String> getFirstThreeCharactersOfNames() {
        return employeeRepo.findFirstThreeCharactersOfNames();
    }
} 