package com.example.EmployeePerformance.Controller;


import com.example.EmployeePerformance.Entity.RatingCategory;
import com.example.EmployeePerformance.Entity.Employee;
import com.example.EmployeePerformance.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("/calculate")
    public List<RatingCategory> calculateActualPercentages() {
        return ratingService.calculateActualPercentages();
    }

    @GetMapping("/suggest")
    public List<Employee> suggestRevisions() {
        return ratingService.suggestRevisions();
    }
}

