package data.service;

import data.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> addCar(List<Car> cars);
}
