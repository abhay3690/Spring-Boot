package data.service.impl;

import data.entity.City;
import data.entity.CityName;
import data.repository.CityRepository;
import data.service.CityService;
import lombok.RequiredArgsConstructor;
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
//        List<City> sorted_city = cityRepository.findAll().stream()
//                .filter(x -> x.getPincode() >= start && x.getPincode() <= end).sorted(new CityName()).toList();
//        return sorted_city;
    }
}
