package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

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

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseServices;

@RestController
public class MyController {
	
	@Autowired
	private CourseServices courseServices;
	
	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseServices.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable("id") long id){
		Optional<Course> s = courseServices.findById(id);
		return s.orElse(new Course());
	}
	
	@PostMapping(path = "/courses",consumes ="application/json	")
	public Course addCourse(@RequestBody Course course) {
		return this.courseServices.save(course);
	}

	@PutMapping("/courses/{courseId}")
	public String updateCourse(@RequestBody Course course,@PathVariable("courseId") long id) {
		this.courseServices.save(course);
		return "update sucessfully";
	}
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable("courseId")long courseId) {
		this.courseServices.deleteById(courseId);
		return "what you like what to you  do";
	}
	
	
}

