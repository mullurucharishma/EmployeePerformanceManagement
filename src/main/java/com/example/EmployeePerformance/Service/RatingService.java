package com.example.EmployeePerformance.Service;

import com.example.EmployeePerformance.Entity.Employee;
import com.example.EmployeePerformance.Entity.RatingCategory;
import com.example.EmployeePerformance.Repository.EmployeeRepository;
import com.example.EmployeePerformance.Repository.RatingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RatingService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RatingCategoryRepository ratingCategoryRepository;

    public List<RatingCategory> calculateActualPercentages() {
        List<RatingCategory> categories = ratingCategoryRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        int totalEmployees = employees.size();

        categories.forEach(category -> {
            long count = employees.stream()
                    .filter(e -> e.getRating().equals(category.getCategory()))
                    .count();
            category.setActualPercentage((int) ((count * 100) / totalEmployees));
        });

        return categories;
    }

    public List<Employee> suggestRevisions() {
        List<RatingCategory> categories = calculateActualPercentages();
        return categories.stream()
                .filter(category -> category.getActualPercentage() > category.getStandardPercentage())
                .flatMap(category -> employeeRepository.findByRating(category.getCategory()).stream())
                .collect(Collectors.toList());
    }
    public Map<String, Double> getBellCurveData() {
        List<RatingCategory> categories = calculateActualPercentages();
        return categories.stream()
                .collect(Collectors.toMap(
                        RatingCategory::getCategory,
                        category -> (double) category.getActualPercentage()
                ));
    }
}
