package com.example.service;

import com.example.entity.Student;
import com.example.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TeacherService {
    Teacher crateTeacher(Teacher teacher);
    List<Teacher> allTeacher();
    Teacher getTeacherId(Integer id);
    Teacher updateTeacher(Teacher teacher, Integer id);
    void deleteTeacher(Integer id);
}
