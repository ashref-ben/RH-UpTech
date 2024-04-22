package com.example.RHSERVICE.Repositories;

import com.example.RHSERVICE.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
