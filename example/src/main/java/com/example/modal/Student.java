package com.example.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private Date createdDate;
    private Date updatedDate;
    private String fatherName;
    private String fatherPhone;
    private String motherName;
    private String motherPhone;
    private String studentNumber;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addressList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;
}