package data.service.impl;

import data.entity.City;
import data.entity.CityName;
import data.exception.ResourceNotFoundException;
import data.repository.CityRepository;
import data.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> addCity(List<City> city) {

        return cityRepository.saveAll(city);
    }

    @Override
    public List<City> getCityWithPincodeRange(long start, long end) {
        return cityRepository.findAll().stream().filter(x -> x.getPincode() >= start && x.getPincode() <= end).sorted(new CityName()).toList();
    }

    @Override
    public City updateCity(City city1,Integer id) {
        City city2 = this.cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        city2.setCityId(id);
        city2.setCityName(city1.getCityName());
        city2.setPincode(city1.getPincode());
        return this.cityRepository.save(city2);
    }

    @Override
    public void deleteCity( Integer id) {
        City data = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        this.cityRepository.delete(data);
    }
}
