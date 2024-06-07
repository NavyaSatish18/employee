package com.example.employee.dto;

import lombok.Data;

@Data
public class EmployeeTaxDetails {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Double yearlySalary;
    private Double taxAmount;
    private Double cessAmount;


}
