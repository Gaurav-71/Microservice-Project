package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService StudentService;

    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping("/")
    public String home() {
        return "<h1>Student Service</h1>";
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return StudentService.getAllStudents();
    }

    @GetMapping("/get/{StudentID}")
    public Student getStudent(@PathVariable String StudentID) {
        return StudentService.getStudent(StudentID);
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student Student) {
        return StudentService.create(Student);
    }

    @DeleteMapping("/deleteStudent/{StudentId}")
    public String deleteStudent(@PathVariable String StudentId) {
        StudentService.delete(StudentId);
        return "Student Deleted";
    }

    @PutMapping("/updateStudent/{StudentId}")
    public Student updateStudent(@RequestBody Student Student, @PathVariable String StudentId) {
        return StudentService.update(Student, StudentId);
    }

    @DeleteMapping("/deleteAll")
    public String deleteStudents() {
        StudentService.deleteAll();
        return "All Students data deleted";
    }
}
