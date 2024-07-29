package data.service;

import data.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car addCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
    Car saveCar(Car car);
    void deleteCar(int id);

}
