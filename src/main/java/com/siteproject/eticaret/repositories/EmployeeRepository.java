package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
