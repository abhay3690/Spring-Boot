package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNumber;
    private String name;
    private String address;
    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;  // Ensure bidirectional mapping
}