package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modal.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    boolean existsByNationalId(String nationalId);
}
