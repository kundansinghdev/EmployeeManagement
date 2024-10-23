package com.EmployeeManagement.service;

import com.EmployeeManagement.dto.DepartmentDTO;
import com.EmployeeManagement.mapper.DepartmentMapper;
import com.EmployeeManagement.model.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for handling Department operations.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(departmentMapper::toDTO);
    }

    public DepartmentDTO createDepartment(@Valid DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDTO(savedDepartment);
    }

    public Optional<DepartmentDTO> updateDepartment(Long id, @Valid DepartmentDTO departmentDTO) {
        if (departmentRepository.existsById(id)) {
            Department department = departmentMapper.toEntity(departmentDTO);
            department.setDepartment_id(id);
            Department updatedDepartment = departmentRepository.save(department);
            return Optional.of(departmentMapper.toDTO(updatedDepartment));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
