package com.example.EmployeePerformance.Controller;

import com.example.EmployeePerformance.Entity.Employee;
import com.example.EmployeePerformance.Entity.RatingCategory;
import com.example.EmployeePerformance.Service.EmployeeService;
import com.example.EmployeePerformance.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RatingService ratingService;


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/actual-percentages")
    public List<RatingCategory> getActualPercentages() {
        return ratingService.calculateActualPercentages();
    }
    @GetMapping("/bell-curve")
    public Map<String, Double> getBellCurve() {
        return ratingService.getBellCurveData();
    }

}
