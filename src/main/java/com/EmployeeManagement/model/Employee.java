package com.EmployeeManagement.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee entity class representing an employee.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    private String name;
    private Integer age;
    private String city;
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id", referencedColumnName = "id")
    private Salary salary;

    // Constructors, getters, and setters
    public Employee() {
    }

    public Employee(String name, Integer age, String city, String designation, Salary salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters and setters for other fields

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    // Getters and setters for employee_id, name, age, city, designation
    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
