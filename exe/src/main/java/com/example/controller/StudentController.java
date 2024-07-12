package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1 = this.studentService.createStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Student>> allUser(){
        List<Student> students = this.studentService.allStudent();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{rollNumber}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer rollNumber){
        Student student = this.studentService.getUserId(rollNumber);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{/rollNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNumber) {
        this.studentService.deleteStudent(rollNumber);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
    @PutMapping("{/rollNumber}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer rollNumber){
        Student updateStudent = this.studentService.updateStudent(student,rollNumber);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }
}
