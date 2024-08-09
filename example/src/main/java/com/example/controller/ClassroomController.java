package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.ClassroomDto;
import com.example.payload.request.classroom.CreateClassroomRequest;
import com.example.payload.request.classroom.UpdateClassroomRequest;
import com.example.service.ClassroomService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<Void> createClassroom(@RequestBody CreateClassroomRequest request) {
        classroomService.createClassroom(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClassroom(@PathVariable String id, @RequestBody UpdateClassroomRequest request) {
        classroomService.updateClassroom(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String id) {
        classroomService.deleteClassroom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> findClassroomById(@PathVariable String id) {
        ClassroomDto classroomDto = classroomService.findClassroomById(id);
        return new ResponseEntity<>(classroomDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClassroomDto>> findAllClassrooms() {
        List<ClassroomDto> classroomDtoList = classroomService.findAllClassrooms();
        return new ResponseEntity<>(classroomDtoList, HttpStatus.OK);
    }
}
