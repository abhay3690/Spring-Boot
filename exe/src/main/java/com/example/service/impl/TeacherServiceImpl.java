package com.example.service.impl;

import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.exception.ResourceNotFoundException;
import com.example.reposity.TeacherRepo;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Teacher crateTeacher(Teacher teacher) {
        // Set teacher reference for each student
        if (teacher.getStudents() != null) {
            for (Student student : teacher.getStudents()) {
                student.setTeacher(teacher);
            }
        }
        return teacherRepo.save(teacher);
    }
    @Override
    public List<Teacher> allTeacher() {
        return this.teacherRepo.findAll();
    }

    @Override
    public Teacher getTeacherId(Integer id) { // corrected method name
        return this.teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("teacher","id",id));
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Integer id) {
        Teacher existingTeacher = this.teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("teacher","id",id));

        existingTeacher.setTeacherName(teacher.getTeacherName());
        existingTeacher.setSubjectCourse(teacher.getSubjectCourse());
        existingTeacher.setStudents(teacher.getStudents());

        if (existingTeacher.getStudents() != null) {
            for (Student student : existingTeacher.getStudents()) {
                student.setTeacher(existingTeacher); // Ensure the relationship is set
            }
        }

        return this.teacherRepo.save(existingTeacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        Teacher teacher = this.teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("teacher","id",id));
        this.teacherRepo.delete(teacher);
    }
}
