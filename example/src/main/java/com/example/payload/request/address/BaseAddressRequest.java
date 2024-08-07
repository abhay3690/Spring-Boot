package com.example.payload.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.example.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseAddressRequest {
    @NotNull(message = ValidationMessage.Address.ADDRESS_STREET_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Address.ADDRESS_STREET_NOT_EMPTY)
    private String street;

    @NotNull(message = ValidationMessage.Address.ADDRESS_CITY_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Address.ADDRESS_CITY_NOT_EMPTY)
    private String city;

    @NotNull(message = ValidationMessage.Address.ADDRESS_STATE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Address.ADDRESS_STATE_NOT_EMPTY)
    private String state;

    @NotNull(message = ValidationMessage.Address.ADDRESS_ZIPCODE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Address.ADDRESS_ZIPCODE_NOT_EMPTY)
    private String zipCode;
}
