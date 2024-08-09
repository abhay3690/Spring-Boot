package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.ClassroomDto;
import com.example.payload.request.classroom.CreateClassroomRequest;
import com.example.payload.request.classroom.UpdateClassroomRequest;
import com.example.service.ClassroomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<Void> createClassroom(@RequestBody CreateClassroomRequest request) {
        classroomService.createClassroom(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClassroom(@PathVariable String id, @RequestBody UpdateClassroomRequest request) {
        classroomService.updateClassroom(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable String id) {
        ClassroomDto classroomDto = classroomService.findClassroomById(id);
        return ResponseEntity.ok(classroomDto);
    }

    @GetMapping
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms() {
        List<ClassroomDto> classroomList = classroomService.findAllClassrooms();
        return ResponseEntity.ok(classroomList);
    }
}
