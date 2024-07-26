package data.service.impl;

import data.entity.Car;
import data.repository.CarRepository;
import data.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    @Transactional
    public List<Car> addCar(List<Car> car) {
        return carRepository.saveAll(car);
    }
}
