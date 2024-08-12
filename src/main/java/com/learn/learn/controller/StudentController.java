package com.learn.learn.controller;

import com.learn.learn.dto.StudentRequest;
import com.learn.learn.model.Student;
import com.learn.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return this.studentService.findAll();
    }

    @PostMapping()
    public Student addStudent(@RequestBody StudentRequest studentRequest) {
        return this.studentService.create(studentRequest);
    }
}
