package com.example.payload.request.student;

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
public class BaseStudentRequest {
    @NotNull(message = ValidationMessage.Student.STUDENT_FIRST_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_FIRST_NAME_NOT_EMPTY)
    private String firstName;

    @NotNull(message = ValidationMessage.Student.STUDENT_LAST_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_LAST_NAME_NOT_EMPTY)
    private String lastName;

    @NotNull(message = ValidationMessage.Student.STUDENT_FATHER_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_FATHER_NAME_NOT_EMPTY)
    private String fatherName;

    @NotNull(message = ValidationMessage.Student.STUDENT_FATHER_PHONE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_FATHER_PHONE_NOT_EMPTY)
    @Pattern(regexp = ValidationMessage.General.PHONE_REGEX,
            message = ValidationMessage.Student.STUDENT_FATHER_PHONE_NOT_VALID)
    private String fatherPhone;

    @NotNull(message = ValidationMessage.Student.STUDENT_MOTHER_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_MOTHER_NAME_NOT_EMPTY)
    private String motherName;

    @NotNull(message = ValidationMessage.Student.STUDENT_MOTHER_PHONE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_MOTHER_PHONE_NOT_EMPTY)
    @Pattern(regexp = ValidationMessage.General.PHONE_REGEX,
            message = ValidationMessage.Student.STUDENT_MOTHER_PHONE_NOT_VALID)
    private String motherPhone;
}