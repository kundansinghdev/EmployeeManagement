package com.EmployeeManagement.dto;

/**
 * Data Transfer Object for Department entity.
 */
public class DepartmentDTO {
    private Long department_id;
    private String department_name;

    // Getters and setters
    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
