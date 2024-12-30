package com.example.EmployeePerformance.Repository;

import com.example.EmployeePerformance.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByRating(String rating);
}
