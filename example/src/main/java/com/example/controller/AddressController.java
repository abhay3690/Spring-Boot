package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.AddressDto;
import com.example.payload.request.address.CreateAddressRequest;
import com.example.payload.request.address.UpdateAddressRequest;
import com.example.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> createAddress(@RequestBody CreateAddressRequest request) {
        addressService.createAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable String id, @RequestBody UpdateAddressRequest request) {
        addressService.updateAddress(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable String id) {
        AddressDto addressDto = addressService.findAddressById(id);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addressList = addressService.findAllAddresses();
        return ResponseEntity.ok(addressList);
    }
}
