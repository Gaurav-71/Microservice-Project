package com.example.departmentservice.controller;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService DepartmentService;

    public DepartmentController(DepartmentService DepartmentService) {
        this.DepartmentService = DepartmentService;
    }

    @GetMapping("/")
    public String home() {
        return "<h1>Department Service</h1>";
    }

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments() {
        return DepartmentService.getAllDepartments();
    }

    @GetMapping("/get/{DepartmentID}")
    public Department getDepartment(@PathVariable String DepartmentID) {
        return DepartmentService.getDepartment(DepartmentID);
    }

    @PostMapping("/createDepartment")
    public Department createDepartment(@RequestBody Department Department) {
        return DepartmentService.create(Department);
    }

    @DeleteMapping("/deleteDepartment/{DepartmentId}")
    public String deleteDepartment(@PathVariable String DepartmentId) {
        DepartmentService.delete(DepartmentId);
        return "Employee Deleted";
    }

    @PutMapping("/updateDepartment/{DepartmentId}")
    public Department updateDepartment(@RequestBody Department Department, @PathVariable String DepartmentId) {
        return DepartmentService.update(Department, DepartmentId);
    }

    @DeleteMapping("/deleteAll")
    public String deleteDepartments() {
        DepartmentService.deleteAll();
        return "All Emplyees data deleted";
    }
}
