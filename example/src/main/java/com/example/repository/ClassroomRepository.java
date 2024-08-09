package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modal.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String> {
    // Custom query methods can be defined here if needed
}
