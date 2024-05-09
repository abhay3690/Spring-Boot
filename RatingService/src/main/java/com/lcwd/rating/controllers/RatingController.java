package com.lcwd.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Ratings;
import com.lcwd.rating.services.RatingServices;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingServices ratingServices;

	@PostMapping("")
	public ResponseEntity<Ratings> create(@RequestBody Ratings ratings) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(ratings));

	}

	@GetMapping("")
	public ResponseEntity<List<Ratings>> getRatings() {
		return ResponseEntity.ok(ratingServices.getRatings());

	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingServices.getRatingsByUserId(userId));
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingServices.getRatingsByHotelId(hotelId));

	}
}
