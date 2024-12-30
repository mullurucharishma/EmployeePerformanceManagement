package com.example.EmployeePerformance.Repository;

import com.example.EmployeePerformance.Entity.RatingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingCategoryRepository extends JpaRepository<RatingCategory, String> {
}
