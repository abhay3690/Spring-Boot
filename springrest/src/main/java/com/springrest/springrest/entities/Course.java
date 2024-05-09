package com.springrest.springrest.entities;

import jakarta.persistence.Entity;

@Entity
public class Course {
	@jakarta.persistence.Id
	private long Id;
	private String title;
	private String description;

	public Course(long id, String title, String description) {
		super();
		Id = id;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", title=" + title + ", description=" + description + "]";
	}

}
