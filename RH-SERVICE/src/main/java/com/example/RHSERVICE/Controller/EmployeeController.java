package com.example.RHSERVICE.Controller;


import com.example.RHSERVICE.Dtos.EmployeeDTO;

import com.example.RHSERVICE.Services.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@Slf4j
@RequestMapping("/Employees")
@Api("RH-SERVICE")
@CrossOrigin("*")
    public class EmployeeController {


    @Autowired
        private IEmployeeService employeeService;
    @Operation(
            summary = "Ajouter un Employee",
            description = "Cette méthode permet d'Ajouter un nouveau Employee "
    )
        @PostMapping
        public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
            EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        }

        @GetMapping("/{employeeId}")
        public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String employeeId) {
            EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
            return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
            List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
            return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
        }

        @PutMapping("/{employeeId}")
        public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String employeeId, @RequestBody EmployeeDTO employeeDTO) {
            EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeId, employeeDTO);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        }

        @DeleteMapping("/{employeeId}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeId) {
            boolean deleted = employeeService.deleteEmployee(employeeId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
