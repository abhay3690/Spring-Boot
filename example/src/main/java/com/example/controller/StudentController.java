package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.StudentDto;
import com.example.payload.request.student.CreateStudentRequest;
import com.example.payload.request.student.UpdateStudentRequest;
import com.example.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody CreateStudentRequest request) {
        studentService.createStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable String id, @RequestBody UpdateStudentRequest request) {
        studentService.updateStudent(id, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/classroom/{classroomId}")
    public ResponseEntity<Void> addStudentToClassroom(@PathVariable String id, @PathVariable String classroomId) {
        studentService.addStudentToClassroom(id, classroomId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/classroom/remove")
    public ResponseEntity<Void> removeStudentFromClassroom(@PathVariable String id) {
        studentService.removeStudentFromClassroom(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id) {
        StudentDto studentDto = studentService.findStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentList = studentService.findAllStudents();
        return ResponseEntity.ok(studentList);
    }
}
