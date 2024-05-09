package com.lcwd.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Ratings;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.services.RatingServices;

@Service
public class RatingsServiceImpl implements RatingServices {
	@Autowired
	private RatingRepository repository;

	@Override
	public Ratings create(Ratings ratings) {
		String s = UUID.randomUUID().toString();
		ratings.setRatingId(s);
		return repository.save(ratings);
	}

	@Override
	public List<Ratings> getRatings() {

		return repository.findAll();
	}

	@Override
	public List<Ratings> getRatingsByUserId(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Ratings> getRatingsByHotelId(String hotelId) {
		return repository.findByHotelId(hotelId);
	}

}
