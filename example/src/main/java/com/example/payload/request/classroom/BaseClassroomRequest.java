package com.example.payload.request.classroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseClassroomRequest {
    @NotNull(message = ValidationMessage.Classroom.CLASSROOM_DESCRIPTION_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Classroom.CLASSROOM_DESCRIPTION_NOT_EMPTY)
    private String description;

    @NotNull(message = ValidationMessage.Classroom.CLASSROOM_TEACHER_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Classroom.CLASSROOM_TEACHER_ID_NOT_EMPTY)
    private String teacherId;
}