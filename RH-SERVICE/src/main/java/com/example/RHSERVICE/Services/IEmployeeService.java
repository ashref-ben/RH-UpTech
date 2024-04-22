package com.example.RHSERVICE.Services;

import com.example.RHSERVICE.Dtos.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(String employeeId);

    EmployeeDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO);

    boolean deleteEmployee(String employeeId);
}
