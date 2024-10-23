package com.EmployeeManagement.mapper;

import com.EmployeeManagement.dto.SalaryDTO;
import com.EmployeeManagement.model.Salary;
import org.springframework.stereotype.Component;

/**
 * Mapper class to convert between Salary and SalaryDTO.
 */
@Component
public class SalaryMapper {

    public SalaryDTO toDTO(Salary salary) {
        if (salary == null) {
            return null;
        }
        SalaryDTO dto = new SalaryDTO();
        dto.setId(salary.getId()); // Use `getId()` for Salary
        dto.setSalary_amount(salary.getSalary_amount());
        return dto;
    }

    public Salary toEntity(SalaryDTO dto) {
        if (dto == null) {
            return null;
        }
        Salary salary = new Salary();
        salary.setId(dto.getId()); // Use `setId()` for Salary
        salary.setSalary_amount(dto.getSalary_amount());
        return salary;
    }
}