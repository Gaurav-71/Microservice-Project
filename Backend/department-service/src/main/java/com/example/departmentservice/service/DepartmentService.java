package com.example.departmentservice.service;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository DepartmentRepository;

    public DepartmentService(DepartmentRepository DepartmentRepository) {
        this.DepartmentRepository = DepartmentRepository;
    }

    public List<Department> getAllDepartments() {
        return DepartmentRepository.findAll();
    }

    public Department getDepartment(String DepartmentID) {
        return DepartmentRepository.findById(DepartmentID).orElse(null);
    }


    public Department create(Department Department) {
        return DepartmentRepository.save(Department);
    }

    public void delete(String DepartmentId) {
        DepartmentRepository.deleteById(DepartmentId);
    }

    public Department update(Department Department, String DepartmentId) {
        Department Department1 = DepartmentRepository.findById(DepartmentId).get();
        Department1.setName(Department.getName());        
        DepartmentRepository.save(Department1);
        return Department1;
    }

    public void deleteAll() {
        DepartmentRepository.deleteAll();
    }
}
