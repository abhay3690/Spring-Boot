package com.example.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> studentList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
