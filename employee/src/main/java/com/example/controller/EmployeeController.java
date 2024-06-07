package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.dto.EmployeeTaxDetails;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }


    @GetMapping("/tax-details")
    public ResponseEntity<List<EmployeeTaxDetails>> getEmployeeTaxDetails() {
        List<EmployeeTaxDetails> taxDetails = employeeService.getEmployeeTaxDetails();
        return ResponseEntity.ok(taxDetails);
    }
}