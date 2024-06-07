package com.example.service;

import com.example.model.Employee;
import com.example.dto.EmployeeTaxDetails;
import com.example.repository.EmployeeRepository;
import com.example.util.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);

        public List<EmployeeTaxDetails> getEmployeeTaxDetails() {
            return employeeRepository.findAll().stream().map(this::mapToEmployeeTaxDetails).collect(Collectors.toList());
        }

        private EmployeeTaxDetails mapToEmployeeTaxDetails(Employee employee) {
            EmployeeTaxDetails taxDetails = new EmployeeTaxDetails();
            double yearlySalary = TaxCalculator.calculateYearlySalary(employee.getSalary(), employee.getDoj());
            double taxAmount = TaxCalculator.calculateTax(yearlySalary);
            double cessAmount = TaxCalculator.calculateCess(yearlySalary);

            taxDetails.setEmployeeId(employee.getId());
            taxDetails.setFirstName(employee.getFirstName());
            taxDetails.setLastName(employee.getLastName());
            taxDetails.setYearlySalary(yearlySalary);
            taxDetails.setTaxAmount(taxAmount);
            taxDetails.setCessAmount(cessAmount);

            return taxDetails;

    }
}