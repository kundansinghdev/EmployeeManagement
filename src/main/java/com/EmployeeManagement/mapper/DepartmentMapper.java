package com.EmployeeManagement.mapper;

import com.EmployeeManagement.dto.DepartmentDTO;
import com.EmployeeManagement.model.Department;
import org.springframework.stereotype.Component;

/**
 * Mapper class to convert between Department and DepartmentDTO.
 */
@Component
public class DepartmentMapper {

    public DepartmentDTO toDTO(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartment_id(department.getDepartment_id());
        dto.setDepartment_name(department.getDepartment_name());
        return dto;
    }

    public Department toEntity(DepartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        Department department = new Department();
        department.setDepartment_id(dto.getDepartment_id());
        department.setDepartment_name(dto.getDepartment_name());
        return department;
    }
}
