package com.example.studentservice.service;

import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository StudentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
    }

    public Student getStudent(String StudentID) {
        return StudentRepository.findById(StudentID).orElse(null);
    }


    public Student create(Student Student) {
        return StudentRepository.save(Student);
    }

    public void delete(String StudentId) {
        StudentRepository.deleteById(StudentId);
    }

    public Student update(Student Student, String StudentId) {
        Student Student1 = StudentRepository.findById(StudentId).get();
        Student1.setName(Student.getName());
        Student1.setDepartment(Student.getDepartment());
        StudentRepository.save(Student1);
        return Student1;
    }

    public void deleteAll() {
        StudentRepository.deleteAll();
    }
}
