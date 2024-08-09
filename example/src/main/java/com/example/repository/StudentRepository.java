package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modal.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByNationalId(String nationalId);
    boolean existsByFatherPhone(String fatherPhone);
    boolean existsByMotherPhone(String motherPhone);
}
