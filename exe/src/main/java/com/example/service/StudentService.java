package com.example.service;

import com.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student createStudent(Student student);
    List<Student> allStudent();
    Student getStudentId(Integer rollNumber);
    Student updateStudent(Student student, Integer rollNumber);
    void deleteStudent(Integer rollNumber);
}
