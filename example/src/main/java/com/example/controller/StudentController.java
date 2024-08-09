package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.StudentDto;
import com.example.payload.request.student.CreateStudentRequest;
import com.example.payload.request.student.UpdateStudentRequest;
import com.example.service.StudentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody CreateStudentRequest request) {
        studentService.createStudent(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable String id, @RequestBody UpdateStudentRequest request) {
        studentService.updateStudent(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/classroom/{classroomId}")
    public ResponseEntity<Void> addStudentToClassroom(@PathVariable String id, @PathVariable String classroomId) {
        studentService.addStudentToClassroom(id, classroomId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/remove-classroom")
    public ResponseEntity<Void> removeStudentFromClassroom(@PathVariable String id) {
        studentService.removeStudentFromClassroom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable String id) {
        StudentDto studentDto = studentService.findStudentById(id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        List<StudentDto> studentDtoList = studentService.findAllStudents();
        return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
    }
}
