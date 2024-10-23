package com.EmployeeManagement.service;

import com.EmployeeManagement.dto.SalaryDTO;
import com.EmployeeManagement.mapper.SalaryMapper;
import com.EmployeeManagement.model.Salary;
import com.EmployeeManagement.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.Optional;

/**
 * Service class for handling Salary operations.
 */
@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private SalaryMapper salaryMapper;

    public Optional<SalaryDTO> getSalaryByEmployeeId(Long employeeId) {
        return salaryRepository.findById(employeeId).map(salaryMapper::toDTO);
    }

    public SalaryDTO createOrUpdateSalary(@Valid SalaryDTO salaryDTO) {
        Salary salary = salaryMapper.toEntity(salaryDTO);
        Salary savedSalary = salaryRepository.save(salary);
        return salaryMapper.toDTO(savedSalary);
    }

    public boolean deleteSalary(Long employeeId) {
        if (salaryRepository.existsById(employeeId)) {
            salaryRepository.deleteById(employeeId);
            return true;
        } else {
            return false;
        }
    }
}
