package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeDto.getEmployeeId());

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();

            if (employeeDto.getFirstName() != null) {
                employee.setFirstName(employeeDto.getFirstName());
            }
            if (employeeDto.getLastName() != null) {
                employee.setLastName(employeeDto.getLastName());
            }
            if (employeeDto.getJob() != null) {
                employee.setJob(employeeDto.getJob());
            }
            if (employeeDto.getSalary() != null) {
                employee.setSalary(employeeDto.getSalary());
            }

            employeeRepository.save(employee);
            return Optional.of(employee);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
