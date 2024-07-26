package data.controller;

import data.entity.Car;
import data.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/addcars")
    public List<Car> addCar(List<Car>cars){
        return carService.addCar(cars);
    }
}
