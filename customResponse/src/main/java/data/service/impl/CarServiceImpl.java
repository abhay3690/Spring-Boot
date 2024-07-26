package data.service.impl;

import data.entity.Car;
import data.entity.City;
import data.repository.CarRepository;
import data.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> addCar(@RequestBody List<Car> cars) {
        return carRepository.saveAll(cars);
    }
}
