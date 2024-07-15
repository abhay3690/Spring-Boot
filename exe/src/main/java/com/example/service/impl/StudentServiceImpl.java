package com.example.service.impl;

import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.reposity.StudentRepo;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student createStudent(Student student) {
        Student student1 = this.studentRepo.save(student);
        return student1;
    }

    @Override
    public List<Student> allStudent() {
        return  this.studentRepo.findAll();
    }
    @Override
    public Student getStudentId(Integer rollNumber) {
        Student student = this.studentRepo.findById(rollNumber).orElseThrow(() -> new ResourceNotFoundException("student","student",rollNumber));
        return student;
    }

    @Override
    public Student updateStudent(Student student, Integer rollNumber) {
        Student student1 =this.studentRepo.findById(rollNumber).orElseThrow(()->new  ResourceNotFoundException("student","student",rollNumber));
        student1.setName(student.getName());
        student1.setAddress(student.getAddress());
        student1.setPhoneNumber(student.getPhoneNumber());
        Student save = this.studentRepo.save(student1);
        return save;
    }

    @Override
    public void deleteStudent(Integer rollNumber) {
        Student student = this.studentRepo.findById(rollNumber).orElseThrow(()->new ResourceNotFoundException("student","student",rollNumber));
        this.studentRepo.delete(student);
       }
}