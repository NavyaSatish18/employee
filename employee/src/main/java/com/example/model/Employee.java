package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @ElementCollection
    @NotEmpty(message = "At least one phone number is mandatory")
    private List<@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number should be valid") String> phoneNumbers;

    @NotNull(message = "Date of joining is mandatory")
    private LocalDate doj;

    @NotNull(message = "Salary is mandatory")
    @Min(value = 0, message = "Salary should be positive")
    private Double salary;


}