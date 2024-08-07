package com.example.payload.request.teacher;



import com.example.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseTeacherRequest {
    @NotNull(message = ValidationMessage.Teacher.TEACHER_FIRST_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Teacher.TEACHER_FIRST_NAME_NOT_EMPTY)
    private String firstName;

    @NotNull(message = ValidationMessage.Teacher.TEACHER_LAST_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Teacher.TEACHER_LAST_NAME_NOT_EMPTY)
    private String lastName;
    @NotNull(message = ValidationMessage.Teacher.TEACHER_PHONE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Teacher.TEACHER_PHONE_NOT_EMPTY)
    @Pattern(regexp = ValidationMessage.General.PHONE_REGEX,
            message = ValidationMessage.Teacher.TEACHER_PHONE_NOT_VALID)
    private String phone;

}