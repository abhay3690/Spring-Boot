package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.address.AddressNotFoundException;
import com.example.helper.BusinessMessage;
import com.example.helper.LogMessage;
import com.example.modal.Address;
import com.example.payload.AddressDto;
import com.example.payload.converter.AddressDtoConverter;
import com.example.payload.request.address.CreateAddressRequest;
import com.example.payload.request.address.UpdateAddressRequest;
import com.example.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final StudentService studentService;
    private final AddressDtoConverter converter;

    public void createAddress(CreateAddressRequest request) {
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());
        address.setStudent(studentService.findStudentByStudentId(request.getStudentId()));

        addressRepository.save(address);
        log.info(LogMessage.Address.AddressCreated());
    }

    public void updateAddress(String id, UpdateAddressRequest request) {
        Address address = findAddressByAddressId(id);

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());

        addressRepository.save(address);
        log.info(LogMessage.Address.AddressUpdated(id));
    }

    public void deleteAddress(String id) {
        Address address = findAddressByAddressId(id);

        addressRepository.delete(address);
        log.info(LogMessage.Address.AddressDeleted(id));
    }

    public AddressDto findAddressById(String id) {
        Address address = findAddressByAddressId(id);

        log.info(LogMessage.Address.AddressFound(id));
        return converter.convert(address);
    }

    public List<AddressDto> findAllAddresses() {
        List<Address> addressList = addressRepository.findAll();

        if (addressList.isEmpty()) {
            log.error(LogMessage.Address.AddressListEmpty());
            throw new AddressNotFoundException(BusinessMessage.Address.ADDRESS_LIST_EMPTY);
        }

        log.info(LogMessage.Address.AddressListed());
        return converter.convert(addressList);
    }


    protected Address findAddressByAddressId(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(LogMessage.Address.AddressNotFound(id));
                    throw new AddressNotFoundException(LogMessage.Address.AddressNotFound(id));
                });
    }
}
