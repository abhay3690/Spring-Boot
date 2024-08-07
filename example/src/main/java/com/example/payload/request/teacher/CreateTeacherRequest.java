package com.example.payload.request.teacher;

import com.example.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherRequest extends BaseTeacherRequest {
    @NotNull(message = ValidationMessage.Teacher.TEACHER_NATIONAL_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Teacher.TEACHER_NATIONAL_ID_NOT_EMPTY)
    @Pattern(regexp = ValidationMessage.General.NATIONAL_ID_REGEX,
            message = ValidationMessage.Teacher.TEACHER_NATIONAL_ID_NOT_VALID)
    private String nationalId;
}