package com.example.payload.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.example.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest extends BaseAddressRequest {
    @NotNull(message = ValidationMessage.Address.ADDRESS_STUDENT_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Address.ADDRESS_STUDENT_ID_NOT_EMPTY)
    private String studentId;
}