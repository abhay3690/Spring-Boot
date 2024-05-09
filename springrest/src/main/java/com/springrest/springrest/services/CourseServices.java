package com.springrest.springrest.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Component
public interface CourseServices extends JpaRepository<Course, Long>{
	
//	public List<Course> getCourses();
//
//	public Course getCourse(long courseId);
//
//	public Course addCourse(Course course);
//	
//	public void updateCourse(Course course,long courseId);
//
//	public void deleteCourse(long parseLong);
	
}
