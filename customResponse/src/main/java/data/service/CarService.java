package data.service;

import data.entity.Car;
import data.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> addCar(List<Car> car);


}
