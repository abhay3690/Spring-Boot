package data.service.impl;

import data.entity.City;
import data.entity.CityName;
import data.exception.ResourceNotFoundException;
import data.repository.CityRepository;
import data.service.CityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;          
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Override
    @Transactional
    public City addCity(City cities) {
        return cityRepository.save(cities);
    }

    @Override
    public List<City> getCityWithPincodeRange(long start, long end) {
        return cityRepository.findAll().stream().filter(x -> x.getPincode() >= start && x.getPincode() <= end).sorted(new CityName()).toList();
    }

    @Override
    @Transactional
    public City updateCity(City city1,Integer id) {
        City existingCity = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

        existingCity.setCityName(city1.getCityName());
        existingCity.setPincode(city1.getPincode());
        return cityRepository.save(existingCity);
    }

    @Override
    public void deleteCity(Integer id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
        cityRepository.delete(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll().stream().toList();
//       return cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer id) {
        if (id == null || id <= 0) {
            logger.error("Invalid city id provided: {}", id);
            throw new IllegalArgumentException("Invalid city id provided");
        }
        logger.info("Request to get city with id: {}", id);
        try {
            City city = cityRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
            logger.info("Successfully retrieved city with id: {}", id);
            return city;
        } catch (ResourceNotFoundException ex) {
            logger.error("City not found with id: {}", id, ex);
            throw ex;
        }
//        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
//        return city;
    }
}

