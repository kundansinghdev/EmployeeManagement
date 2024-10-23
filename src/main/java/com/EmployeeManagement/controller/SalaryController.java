package com.EmployeeManagement.controller;

import com.EmployeeManagement.dto.SalaryDTO;
import com.EmployeeManagement.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

/**
 * Controller class for handling Salary-related HTTP requests.
 */
@RestController
@RequestMapping("/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<SalaryDTO> getSalaryByEmployeeId(@PathVariable Long employeeId) {
        Optional<SalaryDTO> salaryDTO = salaryService.getSalaryByEmployeeId(employeeId);
        return salaryDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalaryDTO> createOrUpdateSalary(@Valid @RequestBody SalaryDTO salaryDTO) {
        SalaryDTO savedSalary = salaryService.createOrUpdateSalary(salaryDTO);
        return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long employeeId) {
        if (salaryService.deleteSalary(employeeId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
