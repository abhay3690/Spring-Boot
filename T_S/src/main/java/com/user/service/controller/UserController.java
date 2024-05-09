package com.user.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.service.entities.Teacher;
import com.user.service.services.TeacherService;

@RestController
public class UserController {
	@Autowired
	private TeacherService teacherService;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping("/Teacher")
	public ResponseEntity<List<Teacher>> getBooks() {
		System.out.println("Hello Abhay");
		List<Teacher> list = this.teacherService.getAllTeacher();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@PostMapping("/Teacher")
	public ResponseEntity<Teacher> addBook(@RequestBody Teacher teacher) {
		Teacher b = null;
		try {
			b = teacherService.addTeacher(teacher);
			System.out.println(teacher);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	@PostMapping("/Teacher")
//	public void insertTeacher(@RequestBody Teacher teacher) {
//		System.out.println("data come in controller . ");
//
//		teacherService.addTeacher(teacher);
//	}
	@PutMapping("/Teacher/{teacherId}")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher,
			@PathVariable("teacherId") int teacherId) {
		try {
			this.teacherService.updateTeacher(teacher, teacherId);
			return ResponseEntity.ok().body(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
//	@PutMapping("Teacher/{teacherId}")
//	public void updateTeacher(@RequestBody Teacher teacher, @PathVariable("teacherId") int teacherId) {
//		teacherService.updateTeacher(teacher, teacherId);
//	}

	@DeleteMapping("/Teacher/{teacherId}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable("teacherId") int teacherId) {
		try {
			this.teacherService.deleteTeacher(teacherId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
//	@DeleteMapping("Teacher/{teacherId}")
//	public void deleteTeacher(@PathVariable("teacherId") int id) {
//		teacherService.deleteTacher(id);
//	}
}
