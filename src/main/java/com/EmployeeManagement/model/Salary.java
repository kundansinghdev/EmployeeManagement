package com.EmployeeManagement.model;

import jakarta.persistence.*;

/**
 * Salary entity class representing the salary of an employee.
 */
@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float salary_amount;

    @OneToOne(mappedBy = "salary")
    private Employee employee;

    // Constructors, getters, and setters
    public Salary() {
    }

    public Salary(Float salary_amount) {
        this.salary_amount = salary_amount;
    }

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
