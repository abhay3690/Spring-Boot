package data.service;

import data.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> addCity(List<City> city);

    List<City> getCityWithPincodeRange(long start, long end);

    City updateCity(City city1, Integer id);

    void deleteCity( Integer id);

    List<City> getAll();

}
