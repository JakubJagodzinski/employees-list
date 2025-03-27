package com.example.demo;

import com.example.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentApi {

    private final DepartmentManager departmentManager;

    @Autowired
    public DepartmentApi(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    @GetMapping("/")
    public Iterable<Department> findAll() {
        return departmentManager.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return departmentManager.findById(id);
    }

    @PostMapping("/save")
    public Department save(@RequestBody Department department) {
        return departmentManager.save(department);
    }

    @PutMapping("/update")
    public Department update(@RequestBody Department department) {
        return departmentManager.save(department);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        departmentManager.deleteById(id);
    }

}
