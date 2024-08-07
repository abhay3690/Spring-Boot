package com.example.payload.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.modal.Address;
import com.example.payload.AddressDto;

@Component
public class AddressDtoConverter {
    public AddressDto convert(Address from){
        return new AddressDto(
                from.getId(),
                from.getStreet(),
                from.getCity(),
                from.getState(),
                from.getZipCode()
        );
    }

    public List<AddressDto> convert(List<Address> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}