package data.controller;

import data.entity.Car;
import data.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/addCar")
public class CarController {
//    private final CarService carService;
//    @PostMapping("/addcar")
//    public List<Car> addCar(@RequestBody List<Car> cars){
//        return carService.addCar(cars);
//    }
}