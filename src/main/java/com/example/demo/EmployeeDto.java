package com.example.demo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String job;
    private BigDecimal salary;

}
