package data.service.impl;

import data.entity.City;
import data.exception.ResourceNotFoundException;
import data.repository.CityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CityServiceImplTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    private Logger logger = LoggerFactory.getLogger(CityServiceImplTest.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testUpdateCity_Success() {
        // Sample data
        Integer cityId = 1;
        City existingCity = new City(cityId, "Old City Name", 123456);
        City updatedCity = new City(cityId, "New City Name", 654321);

        // Mock behavior
        when(cityRepository.findById(cityId)).thenReturn(Optional.of(existingCity));
        when(cityRepository.save(any(City.class))).thenReturn(updatedCity);

        // Call the service method
        City returnedCity = cityService.updateCity(updatedCity, cityId);

        // Verify the result
        assertEquals(updatedCity.getCityId(), returnedCity.getCityId());
        assertEquals(updatedCity.getCityName(), returnedCity.getCityName());
        assertEquals(updatedCity.getPincode(), returnedCity.getPincode());

        // Verify that findById method of repository was called once
        verify(cityRepository, times(1)).findById(cityId);

        // Verify that save method of repository was called once with the updated city
        verify(cityRepository, times(1)).save(updatedCity);
    }

    @Test
    public void testUpdateCity_ResourceNotFoundException() {
        // Sample data
        Integer cityId = 1;
        City updatedCity = new City(cityId, "New City Name", 654321);

        // Mock behavior
        when(cityRepository.findById(cityId)).thenReturn(Optional.empty());

        // Call the service method and expect ResourceNotFoundException
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            cityService.updateCity(updatedCity, cityId);
        });

        // Verify the exception message
        assertEquals("City not found with id : 1", exception.getMessage());

        // Verify that findById method of repository was called once
        verify(cityRepository, times(1)).findById(cityId);

        // Verify that save method of repository was not called
        verify(cityRepository, never()).save(any(City.class));
    }
    @Test
    public void testDeleteCity_Success() {
        // Sample data
        Integer cityId = 1;
        City existingCity = new City(cityId, "City Name", 123456);

        // Mock behavior
        when(cityRepository.findById(cityId)).thenReturn(Optional.of(existingCity));

        // Call the service method
        cityService.deleteCity(cityId);

        // Verify that findById and delete methods of repository were called once
        verify(cityRepository, times(1)).findById(cityId);
        verify(cityRepository, times(1)).delete(existingCity);
    }

    @Test
    public void testDeleteCity_ResourceNotFoundException() {
        // Sample data
        Integer cityId = 1;

        // Mock behavior
        when(cityRepository.findById(cityId)).thenReturn(Optional.empty());

        // Call the service method and expect ResourceNotFoundException
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            cityService.deleteCity(cityId);
        });

        // Verify the exception message
        assertEquals("City not found with id : 1", exception.getMessage());

        // Verify that findById method of repository was called once
        verify(cityRepository, times(1)).findById(cityId);

        // Verify that delete method of repository was not called
        verify(cityRepository, never()).delete(any(City.class));
    }
    @Test
    public void testGetAll() {
        // Sample data
        City city1 = new City(1, "City A", 123456);
        City city2 = new City(2, "City B", 654321);
        List<City> cities = Arrays.asList(city1, city2);

        // Mock behavior
        when(cityRepository.findAll()).thenReturn(cities);

        // Call the service method
        List<City> returnedCities = cityService.getAll();

        // Verify the result
        assertEquals(cities.size(), returnedCities.size());
        for (int i = 0; i < cities.size(); i++) {
            assertEquals(cities.get(i).getCityId(), returnedCities.get(i).getCityId());
            assertEquals(cities.get(i).getCityName(), returnedCities.get(i).getCityName());
            assertEquals(cities.get(i).getPincode(), returnedCities.get(i).getPincode());
        }

        // Verify that findAll method of repository was called once
        verify(cityRepository, times(1)).findAll();
    }
    @Test
    public void testGetCityWithPincodeRange() {
        // Create sample cities with different pincodes
        City city1 = new City(1,"City1", 12345);
        City city2 = new City(2,"City2", 23456);
        City city3 = new City(3,"City3", 34567);

        // Mock the behavior of cityRepository.findAll()
        when(cityRepository.findAll()).thenReturn(Arrays.asList(city1, city2, city3));

        // Define the range for pincode
        long start = 20000;
        long end = 30000;

        // Call the method under test
        List<City> result = cityService.getCityWithPincodeRange(start, end);

        // Assert the result
        Assertions.assertThat(result).containsExactly(city2); // City2's pincode (23456) falls within the range [20000, 30000]
    }

    @Test
    public void testGetCityById_InvalidId_ThrowsIllegalArgumentException() {
        // Test for null id
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            cityService.getCityById(null);
        });
        assertEquals("Invalid city id provided", thrown.getMessage());

        // Test for negative id
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            cityService.getCityById(-1);
        });
        assertEquals("Invalid city id provided", thrown.getMessage());
    }
    @Test
    public void testGetCityById_CityNotFound_ThrowsResourceNotFoundException() {
        // Arrange
        int validId = 1;
        when(cityRepository.findById(validId)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () -> {
            cityService.getCityById(validId);
        });
        assertEquals("City not found with id : 1", thrown.getMessage());
    }
    @Test
    public void testGetCityById_CityFound_ReturnsCity() {
        // Arrange
        int validId = 1;
        City mockCity = new City();
        mockCity.setCityId(validId);
        when(cityRepository.findById(validId)).thenReturn(Optional.of(mockCity));
        // Act
        City result = cityService.getCityById(validId);
        // Assert
        assertEquals(validId, result.getCityId());
    }
}
