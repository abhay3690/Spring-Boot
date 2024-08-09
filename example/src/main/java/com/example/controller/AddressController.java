package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.AddressDto;
import com.example.payload.request.address.CreateAddressRequest;
import com.example.payload.request.address.UpdateAddressRequest;
import com.example.service.AddressService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> createAddress(@RequestBody CreateAddressRequest request) {
        addressService.createAddress(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable String id, @RequestBody UpdateAddressRequest request) {
        addressService.updateAddress(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable String id) {
        AddressDto addressDto = addressService.findAddressById(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> findAllAddresses() {
        List<AddressDto> addressDtoList = addressService.findAllAddresses();
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }
}
