package com.EmployeeManagement.mapper;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.model.Employee;
import org.springframework.stereotype.Component;

/**
 * Mapper class to convert between Employee and EmployeeDTO.
 */
@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployee_id(employee.getEmployee_id());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setCity(employee.getCity());
        dto.setDesignation(employee.getDesignation());
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setEmployee_id(dto.getEmployee_id());
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setCity(dto.getCity());
        employee.setDesignation(dto.getDesignation());
        return employee;
    }
}
