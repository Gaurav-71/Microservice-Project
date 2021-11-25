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
        return "<h1>Department Service</h1> <ul> <li><a href='/getCollegeName'>View College Name</a></li> <li><a href='/getAllDepartments'>View All Departments</a></li> <li><a href='/deleteAll'>Delete All Departments</a></li><li>Perform Add/Update operations using Postman</li><li><a href='http://localhost:8761/' target='_blank'>View Eureka Server </a> </li> <li><a href='http://localhost:8081/' target='_blank'> View Student Application Service</a></li> </ul> <span>Made By Gaurav V & Divya</span>";
    }

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments() {
        return DepartmentService.getAllDepartments();
    }

    @GetMapping("/getCollegeName")
    public String getCollegeName() {
        return "<h3>M.S. Ramaiah Institute of Technology</h3>";
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
        return "<h3>Department Deleted</h3>";
    }

    @PutMapping("/updateDepartment/{DepartmentId}")
    public Department updateDepartment(@RequestBody Department Department, @PathVariable String DepartmentId) {
        return DepartmentService.update(Department, DepartmentId);
    }

    @DeleteMapping("/deleteAll")
    public String deleteDepartments() {
        DepartmentService.deleteAll();
        return "<h3>All Departments data deleted</h3>";
    }
}
