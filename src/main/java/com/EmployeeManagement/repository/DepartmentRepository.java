package com.EmployeeManagement.repository;

import com.EmployeeManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Department entity.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
