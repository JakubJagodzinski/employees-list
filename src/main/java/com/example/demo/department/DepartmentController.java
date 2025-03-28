package com.example.demo.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public Iterable<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @PostMapping("/save")
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/update")
    public Department update(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.deleteById(id);
    }

}
