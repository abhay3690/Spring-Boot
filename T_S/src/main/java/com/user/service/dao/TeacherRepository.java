package com.user.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.user.service.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
	public Teacher findById(int id);
}
