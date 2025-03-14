package com.examly.springapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByHireDate(LocalDate hireDate);
    
    @Query("SELECT SUBSTRING(e.name, 1, 3) FROM Employee e")
    List<String> findFirstThreeCharactersOfNames();
} 