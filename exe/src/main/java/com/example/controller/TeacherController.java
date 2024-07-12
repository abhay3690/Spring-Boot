package com.example.controller;

import com.example.entity.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        Teacher teacher1 =this.teacherService.crateTeacher(teacher);
        return new ResponseEntity<>(teacher1, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Teacher>> allTeacher(){
        List<Teacher> teachers = this.teacherService.allTeacher();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id){
        Teacher teacher = this.teacherService.getTeacherId(id);
        return ResponseEntity.ok(teacher);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
        this.teacherService.deleteTeacher(id);
        return new ResponseEntity<>("Teacher deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer id){
        Teacher updateTeacher = this.teacherService.updateTeacher(teacher,id);
        return new ResponseEntity<>(updateTeacher,HttpStatus.OK);
    }
}
