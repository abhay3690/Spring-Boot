package com.user.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.user.service.dao.TeacherRepository;
import com.user.service.entities.Teacher;

@Component
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> getAllTeacher() {
		List<Teacher> list = (List<Teacher>) this.teacherRepository.findAll();
		return list;
	}

	public Teacher getBookById(int id) {
		Teacher teacher = null;
		try {
			teacher = this.teacherRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}
	public Teacher addTeacher(Teacher teacher) {
		Teacher result = teacherRepository.save(teacher);	
		return teacher;
	}
	public void deleteTeacher(int bid) {
		teacherRepository.deleteById(bid);
	}
	public void updateTeacher(Teacher teacher, int teacherId) {

		teacher.setId(teacherId);
		teacherRepository.save(teacher);
	}

	
}
