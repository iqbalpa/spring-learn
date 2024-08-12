package com.learn.learn.service;

import com.learn.learn.dto.StudentRequest;
import com.learn.learn.model.Student;
import com.learn.learn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    public Student findById(int id) {
        return this.studentRepository.findById(id).get();
    }

    public Student create(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        return studentRepository.save(student);
    }
}
