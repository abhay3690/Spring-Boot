package com.projects.service.customer;

import com.projects.dto.BookACarDto;
import com.projects.dto.CarDto;
import com.projects.dto.CarDtoListDto;
import com.projects.dto.SearchCarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<CarDto> getAllCars();
    boolean bookACar(BookACarDto bookACarDto);
    CarDto getCarById(Long carId);
    List<BookACarDto> getBookingsByUserId(Long userId);
    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
