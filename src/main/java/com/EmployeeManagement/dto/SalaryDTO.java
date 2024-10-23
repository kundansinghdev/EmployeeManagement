package com.EmployeeManagement.dto;

/**
 * Data Transfer Object for Salary.
 */
public class SalaryDTO {

    private Long id; // Ensure this field is included
    private Float salary_amount;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSalary_amount() {
        return salary_amount;
    }

    public void setSalary_amount(Float salary_amount) {
        this.salary_amount = salary_amount;
    }
}
