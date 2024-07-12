package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        logger.info("Creating student: {}", student);
        Student student1 = this.studentService.createStudent(student);
        logger.info("Created student: {}", student1);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> allUser(){
        logger.info("Fetching all students");
        List<Student> students = this.studentService.allStudent();
        logger.info("Fetched {} students", students.size());
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{rollNumber}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer rollNumber){
        logger.info("Fetching student with roll number: {}", rollNumber);
        Student student = this.studentService.getStudentId(rollNumber);
        logger.info("Fetched student: {}", student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{rollNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNumber) {
        logger.info("Deleting student with roll number: {}", rollNumber);
        this.studentService.deleteStudent(rollNumber);
        logger.info("Deleted student with roll number: {}", rollNumber);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{rollNumber}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer rollNumber){
        logger.info("Updating student with roll number {}: {}", rollNumber, student);
        Student updateStudent = this.studentService.updateStudent(student,rollNumber);
        logger.info("Updated student: {}", updateStudent);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }
}
