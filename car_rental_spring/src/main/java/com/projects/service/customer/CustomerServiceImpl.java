package com.projects.service.customer;

import com.projects.dto.BookACarDto;
import com.projects.dto.CarDto;
import com.projects.dto.CarDtoListDto;
import com.projects.dto.SearchCarDto;
import com.projects.entity.BookACar;
import com.projects.entity.Car;
import com.projects.entity.User;
import com.projects.enums.BookCarStatus;
import com.projects.repository.BookACarRepository;
import com.projects.repository.CarRepository;
import com.projects.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BookACarRepository bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar =carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser =userRepository.findById(bookACarDto.getUserId());
        if (optionalCar.isPresent()&&optionalUser.isPresent()){
            Car existingCar = optionalCar.get();
            BookACar bookACar = new BookACar();
            bookACar.setUser(optionalUser.get());
            bookACar.setCar(existingCar);
            bookACar.setBookCarStatus(BookCarStatus.PENDING);
            long DiffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFormDate().getTime();
            long days = TimeUnit.MICROSECONDS.toDays(DiffInMilliSeconds);
            bookACar.setDays(days);
            bookACar.setPrice(existingCar.getPrice()*days);
            bookACarRepository.save(bookACar);
            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("brand", ExampleMatcher.GenericPropertyMatcher.contains().ignoreCase())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatcher.contains().ignoreCase())
                .withMatcher("transmission", ExampleMatcher.GenericPropertyMatcher.contains().ignoreCase())
                .withMatcher("color", ExampleMatcher.GenericPropertyMatcher.contains().ignoreCase());
        Example<Car> carExample = Example.of(car,exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;
    }
}
