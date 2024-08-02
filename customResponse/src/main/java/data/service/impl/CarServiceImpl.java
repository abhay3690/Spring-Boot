package data.service.impl;

import data.entity.Car;
import data.entity.City;
import data.repository.CarRepository;
import data.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    public Car addCar(Car car) {
        City city = new City();
        city.setCityId(car.getCity().getCityId());
        Car save = carRepository.save(car);
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElse(null);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

}
