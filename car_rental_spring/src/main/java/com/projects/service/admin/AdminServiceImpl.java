package com.projects.service.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.projects.dto.BookACarDto;
import com.projects.dto.CarDto;
import com.projects.dto.CarDtoListDto;
import com.projects.dto.SearchCarDto;
import com.projects.entity.BookACar;
import com.projects.entity.Car;
import com.projects.enums.BookCarStatus;
import com.projects.repository.BookACarRepository;
import com.projects.repository.CarRepository;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final CarRepository carRepository;

    private final BookACarRepository bookACarRepository;

    @Override
    public boolean postCar(CarDto carDto) throws IOException {
        try {
            Car car = new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setType(carDto.getType());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setImage(carDto.getImage().getBytes());
            carRepository.save(car);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public boolean updateCar(Long carId, CarDto carDto) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()){
            Car existingCar = optionalCar.get();
            if (carDto.getImage() != null){
                existingCar.setImage(carDto.getImage().getBytes());
            }
            existingCar.setPrice(carDto.getPrice());
            existingCar.setYear(carDto.getYear());
            existingCar.setType(carDto.getType());
            existingCar.setDescription(carDto.getDescription());
            existingCar.setTransmission(carDto.getTransmission());
            existingCar.setColor(carDto.getColor());
            existingCar.setName(carDto.getName());
            existingCar.setBrand(carDto.getBrand());
            carRepository.save(existingCar);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<BookACarDto> getBookings() {
        return bookACarRepository.findAll().stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    @Override
    public boolean changeBookingStatus(Long bookingId, String status) {
        Optional<BookACar> optionalBookACar = bookACarRepository.findById(bookingId);
        if (optionalBookACar.isPresent()){
            BookACar existingCar = optionalBookACar.get();
            if (Objects.equals(status,"Approve"))
                existingCar.setBookCarStatus(BookCarStatus.APPROVED);
            else
                existingCar.setBookCarStatus(BookCarStatus.REJECTED);
            bookACarRepository.save(existingCar);
            return true;
        }
        return false;
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matchingAll()
                .withMatcher("brand",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("transmission",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample = Example.of(car,exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;
    }
}
//
//import com.projects.dto.BookACarDto;
//import com.projects.dto.CarDto;
//import com.projects.dto.CarDtoListDto;
//import com.projects.dto.SearchCarDto;
//import com.projects.entity.BookACar;
//import com.projects.entity.Car;
//import com.projects.enums.BookCarStatus;
//import com.projects.repository.BookACarRepository;
//import com.projects.repository.CarRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.stereotype.Service;
//
//import java.awt.print.Book;
//import java.io.IOException;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class AdminServiceImpl implements AdminService{
//    private final CarRepository carRepository;
//    private final BookACarRepository bookACarRepository;
//
//    @Override
//    public boolean postCar(CarDto carDto) throws IOException {
//        try {
//            Car car = new Car();
//            car.setName(carDto.getName());
//            car.setBrand(carDto.getBrand());
//            car.setColor(carDto.getColor());
//            car.setPrice(carDto.getPrice());
//            car.setYear(carDto.getYear());
//            car.setType(carDto.getType());
//            car.setDescription(carDto.getDescription());
//            car.setTransmission(carDto.getTransmission());
//            car.setImage(carDto.getImage().getBytes());
//            car.setColor(carDto.getColor());
//            carRepository.save(car);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public List<CarDto> getAllCars() {
//        return carRepository.findAll().stream().map(Car :: getCarDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteCar(Long id) {
//        carRepository.deleteById(id);
//    }
//
//    @Override
//    public CarDto getCarById(Long id) {
//        Optional<Car> optionalCar = carRepository.findById(id);
//        return optionalCar.map(Car::getCarDto).orElse(null);
//    }
//
//    @Override
//    public boolean updateCar(Long carId, CarDto carDto) throws IOException {
//        Optional<Car> optionalCar = carRepository.findById(carId);
//        if (optionalCar.isPresent()){
//            Car existingCar = optionalCar.get();
//            if (carDto.getImage()!= null){
//                existingCar.setImage(carDto.getImage().getBytes());
//            }
//            existingCar.setPrice(carDto.getPrice());
//            existingCar.setYear(carDto.getYear());
//            existingCar.setType(carDto.getType());
//            existingCar.setDescription(carDto.getDescription());
//            existingCar.setTransmission(carDto.getTransmission());
//            existingCar.setColor(carDto.getColor());
//            existingCar.setName(carDto.getName());
//            existingCar.setBrand(carDto.getBrand());
//            carRepository.save(existingCar);
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    @Override
//    public List<BookACarDto> getBookings() {
//        return bookACarRepository.findAll().stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public boolean changeBookingsStatus(Long bookingId, String status) {
//        Optional<BookACar> optionalBookACar = bookACarRepository.findById(bookingId);
//        if (optionalBookACar.isPresent()){
//            BookACar existBookingCar = optionalBookACar.get();
//            if (Objects.equals(status,"Approve")){
//                existBookingCar.setBookCarStatus(BookCarStatus.APPROVED);
//            }else {
//                existBookingCar.setBookCarStatus(BookCarStatus.REJECTED);
//            }
//            bookACarRepository.save(existBookingCar);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
//        Car car = new Car();
//        car.setBrand(searchCarDto.getBrand());
//        car.setType(searchCarDto.getType());
//        car.setTransmission(searchCarDto.getTransmission());
//        car.setColor(searchCarDto.getColor());
//
//        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
//                .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//                .withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//                .withMatcher("color", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//
//
//        Example<Car> carExample = Example.of(car, exampleMatcher);
//        List<Car> carList = carRepository.findAll(carExample);
//
//        CarDtoListDto carDtoListDto = new CarDtoListDto();
//        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
//        return carDtoListDto;
//    }
//}
