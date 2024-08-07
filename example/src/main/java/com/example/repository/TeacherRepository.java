package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modal.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    boolean existsByNationalId(Object unknownAttr1);
}
