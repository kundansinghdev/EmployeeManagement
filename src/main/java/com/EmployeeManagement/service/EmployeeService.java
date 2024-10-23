package com.EmployeeManagement.service;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.mapper.EmployeeMapper;
import com.EmployeeManagement.model.Employee;
import com.EmployeeManagement.model.Salary;
import com.EmployeeManagement.repository.EmployeeRepository;
import com.EmployeeManagement.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for handling Employee operations.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::toDTO);
    }

    public EmployeeDTO createEmployee(@Valid EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Float salaryAmount = determineSalaryBasedOnDesignation(employee.getDesignation());
        Salary salary = new Salary(salaryAmount);
        employee.setSalary(salary);
        salary.setEmployee(employee);  // set the bidirectional relationship
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    public Optional<EmployeeDTO> updateEmployee(Long id, @Valid EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeMapper.toEntity(employeeDTO);
            employee.setEmployee_id(id);
            Employee existingEmployee = employeeRepository.findById(id).orElseThrow();
            Float salaryAmount = determineSalaryBasedOnDesignation(employee.getDesignation());
            existingEmployee.getSalary().setSalary_amount(salaryAmount);
            employee.setSalary(existingEmployee.getSalary());
            Employee updatedEmployee = employeeRepository.save(employee);
            return Optional.of(employeeMapper.toDTO(updatedEmployee));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private Float determineSalaryBasedOnDesignation(String designation) {
        switch (designation.toLowerCase()) {
            case "junior developer":
                return 50000.0f;
            case "developer":
                return 60000.0f;
            case "senior developer":
                return 75000.0f;
            case "manager":
                return 90000.0f;
            case "intern":
                return 30000.0f;
            case "team lead":
                return 85000.0f;
            default:
                return 55000.0f;  // Default salary for unspecified designations
        }
    }
}
