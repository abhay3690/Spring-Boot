package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.TeacherDto;
import com.example.payload.request.teacher.CreateTeacherRequest;
import com.example.payload.request.teacher.UpdateTeacherRequest;
import com.example.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Void> createTeacher(@RequestBody CreateTeacherRequest request) {
        teacherService.createTeacher(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable String id, @RequestBody UpdateTeacherRequest request) {
        teacherService.updateTeacher(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable String id) {
        TeacherDto teacherDto = teacherService.findTeacherById(id);
        return ResponseEntity.ok(teacherDto);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> teacherList = teacherService.findAllTeachers();
        return ResponseEntity.ok(teacherList);
    }
}
