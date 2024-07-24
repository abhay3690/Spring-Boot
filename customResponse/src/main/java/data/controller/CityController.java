package data.controller;

import data.entity.City;
import data.exception.ResponseHandler;
import data.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/addcity")
    public List<City> addCity(@RequestBody List<City> city) {
        return cityService.addCity(city);
    }

//    @GetMapping("/getcityswithpincode")
//    public ResponseEntity<Object> getCityWithPincode(@RequestParam long startpostcoderange,
//                                                     @RequestParam long endpostcoderange) {
//        List<City> data = cityService.getCityWithPincodeRange(startpostcoderange, endpostcoderange);
//
//        String str = "";
//        for (City list : data) {
//            str += list.getCityName();
//        }
//
//
//        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, data, str.length());
//    }
@GetMapping("/getcityswithpincode")
public ResponseEntity<Object> getCityWithPincode(@RequestParam long startpostcoderange,
                                                 @RequestParam long endpostcoderange) {
    List<City> data = cityService.getCityWithPincodeRange(startpostcoderange, endpostcoderange);

    StringBuilder sb = new StringBuilder();
    for (City city : data) {
        sb.append(city.getCityName());
    }

    String concatenatedCityNames = sb.toString();

    return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, data, concatenatedCityNames.length());
}
}