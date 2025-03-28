package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public Iterable<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody EmployeeDto employeeDto) {
        Optional<Employee> existingEmployee = employeeService.findById(employeeDto.getEmployeeId());

        if (existingEmployee.isPresent()) {
            if (employeeDto.getEmployeeId() != null) {
                existingEmployee.get().setEmployeeId(employeeDto.getEmployeeId());
            }

            if (employeeDto.getFirstName() != null) {
                existingEmployee.get().setFirstName(employeeDto.getFirstName());
            }

            if (employeeDto.getLastName() != null) {
                existingEmployee.get().setLastName(employeeDto.getLastName());
            }

            if (employeeDto.getJob() != null) {
                existingEmployee.get().setJob(employeeDto.getJob());
            }

            if (employeeDto.getSalary() != null) {
                existingEmployee.get().setSalary(employeeDto.getSalary());
            }

            employeeService.save(existingEmployee.get());
            return ResponseEntity.ok(existingEmployee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
