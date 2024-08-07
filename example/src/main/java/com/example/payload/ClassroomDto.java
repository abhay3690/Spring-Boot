package com.example.payload;

import java.util.List;

public record ClassroomDto(
	    String id,
	    String name,
	    String description,
	    String teacherId,
	    List<ClassroomStudentDto> studentList
	) {
	}