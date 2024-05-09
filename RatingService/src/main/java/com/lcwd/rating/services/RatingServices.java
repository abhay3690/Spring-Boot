package com.lcwd.rating.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Ratings;

@Service
public interface RatingServices {
//create
	Ratings create(Ratings ratings);

//getall by rating 
	List<Ratings> getRatings();

//getall by userId 
	List<Ratings> getRatingsByUserId(String userId);

//get all by hotel
	List<Ratings> getRatingsByHotelId(String hotelId);
}
