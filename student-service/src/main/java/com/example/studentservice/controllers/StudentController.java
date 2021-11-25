package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService StudentService;

    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home() {
        return "<h1>Student Application Service</h1> <ul> <li><a href='/getAllStudents'>View All Students</a></li> <li><a href='/getCollegeName'>View College Name (Called through Department Service)</a></li> <li><a href='/getAllDepartments'>View All Departments (Called through Department Service)</a></li> <li>Perform Add/Update operations using Postman</li><li><a href='http://localhost:8761/' target='_blank'>View Eureka Server </a> </li> <li><a href='http://localhost:8080/' target='_blank'> View Department Service</a></li> </ul> <span>Made By Gaurav V & Divya</span> ";
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

    @GetMapping("/getCollegeName")
    public ResponseEntity<String> getCollegeName() throws Exception{
        try{
            return new ResponseEntity<String>(restTemplate.getForObject(getBaseUrl()+"/getCollegeName",String.class), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(restTemplate.getForObject(getBaseUrl()+"/getCollegeName",String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List> getAllDepartments() throws Exception{
        try{
            return new ResponseEntity<List>(restTemplate.getForObject(getBaseUrl()+"/getAllDepartments",List.class), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<List>(restTemplate.getForObject(getBaseUrl()+"/getAllDepartments",List.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getBaseUrl(){
        ServiceInstance instance = loadBalancerClient.choose("DEPARTMENT-SERVICE");
        return instance.getUri().toString();
    }

}
