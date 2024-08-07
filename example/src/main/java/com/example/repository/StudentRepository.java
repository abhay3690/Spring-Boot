package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modal.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByMotherPhone(String motherPhone);
    boolean existsByFatherPhone(String fatherPhone);
    boolean existsByNationalId(String nationalId);
}