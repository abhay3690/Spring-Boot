package com.projects.service.admin;

import com.projects.dto.BookACarDto;
import com.projects.dto.CarDto;
import com.projects.dto.CarDtoListDto;
import com.projects.dto.SearchCarDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
    List<CarDto> getAllCars();
    void deleteCar(Long id);
    CarDto getCarById(Long id);
    boolean updateCar(Long carId, CarDto carDto) throws IOException;
    List<BookACarDto> getBookings();
    boolean changeBookingsStatus(Long bookingId, String status);
    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
