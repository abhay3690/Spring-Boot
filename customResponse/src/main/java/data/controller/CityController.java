package data.controller;

import data.entity.City;
import data.exception.ApiResponse;
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

    @GetMapping("/getcityswithpincode")
    public ResponseEntity<Object> getCityWithPincode(@RequestParam long startpostcoderange,
                                                     @RequestParam long endpostcoderange) {
        List<City> data = cityService.getCityWithPincodeRange(startpostcoderange, endpostcoderange);
        StringBuilder sb = new StringBuilder();
        for (City city : data) {
        sb.append(city.getCityName());
        sb.indexOf(city.getCityName());
        }
        String concatenatedCityNames = sb.toString();

        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, data, concatenatedCityNames.length());
    }
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@RequestBody City city,@PathVariable("id") Integer id){
        City city1 = this.cityService.updateCity(city, id);
        return ResponseEntity.ok(city1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCity(@PathVariable int id) {
        this.cityService.deleteCity(id);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }
}