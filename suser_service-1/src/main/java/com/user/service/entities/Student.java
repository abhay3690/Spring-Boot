package com.user.service.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int StudentId;
	@Column(name = "f_Name")
	private String fName;
	private String lName;
	private String langauage;
	@OneToOne(mappedBy = "student")
	@JsonBackReference
	private Teacher teacher;

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getLangauage() {
		return langauage;
	}

	public void setLangauage(String langauage) {
		this.langauage = langauage;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

//	public Student(int studentId, String fName, String lName, String langauage, Teacher teacher) {
//		super();
//		StudentId = studentId;
//		this.fName = fName;
//		this.lName = lName;
//		this.langauage = langauage;
//		this.teacher = teacher;
//	}
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String fName, String lName, String langauage, Teacher teacher) {
	super();
	StudentId = studentId;
	this.fName = fName;
	this.lName = lName;
	this.langauage = langauage;
	this.teacher = teacher;
}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", fName=" + fName + ", lName=" + lName + ", langauage=" + langauage
				+ ", teacher=" + teacher + "]";
	}

}
