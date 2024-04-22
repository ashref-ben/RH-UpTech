package com.example.RHSERVICE.Services;

import com.example.RHSERVICE.Dtos.EmployeeDTO;
import com.example.RHSERVICE.Models.Employee;
import com.example.RHSERVICE.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements IEmployeeService {



    @Autowired
    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEmployeeEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        Employee employee = employeeRepository.findById(Long.valueOf(employeeId))
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + employeeId));
        return mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(Long.valueOf(employeeId))
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + employeeId));
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setFamilyName(employeeDTO.getFamilyName());
        existingEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        existingEmployee.setSex(employeeDTO.getSex());
        existingEmployee.setAddress(employeeDTO.getAddress());
        existingEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
        existingEmployee.setPosition(employeeDTO.getPosition());
        existingEmployee.setDateOfStart(employeeDTO.getDateOfStart());
        existingEmployee.setDateOfEnd(employeeDTO.getDateOfEnd());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return mapToEmployeeDTO(updatedEmployee);
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        employeeRepository.deleteById(Long.valueOf(employeeId));
        return true;
    }

    private EmployeeDTO mapToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setFamilyName(employee.getFamilyName());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setSex(employee.getSex());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setDateOfStart(employee.getDateOfStart());
        employeeDTO.setDateOfEnd(employee.getDateOfEnd());
        return employeeDTO;
    }

    private Employee mapToEmployeeEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setName(employeeDTO.getName());
        employee.setFamilyName(employeeDTO.getFamilyName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setSex(employeeDTO.getSex());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setPosition(employeeDTO.getPosition());
        employee.setDateOfStart(employeeDTO.getDateOfStart());
        employee.setDateOfEnd(employeeDTO.getDateOfEnd());
        return employee;
    }
}
