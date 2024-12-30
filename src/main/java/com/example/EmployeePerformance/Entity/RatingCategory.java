package com.example.EmployeePerformance.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class RatingCategory {
    @Id
    private String category;
    @Column(nullable = false)
    private int standardPercentage;

    @Transient
    private int actualPercentage; // Calculated dynamically

    @Transient
    private int deviation; // Calculated as (actualPercentage - standardPercentage)

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStandardPercentage() {
        return standardPercentage;
    }

    public void setStandardPercentage(int standardPercentage) {
        this.standardPercentage = standardPercentage;
    }

    public int getActualPercentage() {
        return actualPercentage;
    }

    public void setActualPercentage(int actualPercentage) {
        this.actualPercentage = actualPercentage;
    }

    public int getDeviation() {
        return deviation;
    }

    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }
}
