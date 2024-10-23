package com.EmployeeManagement.repository;

import com.EmployeeManagement.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Salary entity.
 */
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
