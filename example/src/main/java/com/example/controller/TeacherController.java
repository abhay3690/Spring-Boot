package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.TeacherDto;
import com.example.payload.request.teacher.CreateTeacherRequest;
import com.example.payload.request.teacher.UpdateTeacherRequest;
import com.example.service.TeacherService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Void> createTeacher(@RequestBody CreateTeacherRequest request) {
        teacherService.createTeacher(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable String id, @RequestBody UpdateTeacherRequest request) {
        teacherService.updateTeacher(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> findTeacherById(@PathVariable String id) {
        TeacherDto teacherDto = teacherService.findTeacherById(id);
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> findAllTeachers() {
        List<TeacherDto> teacherDtoList = teacherService.findAllTeachers();
        return new ResponseEntity<>(teacherDtoList, HttpStatus.OK);
    }
}
