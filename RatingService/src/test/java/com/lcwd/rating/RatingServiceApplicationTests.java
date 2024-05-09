package com.lcwd.rating;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.lcwd.rating.services.RatingServices;
import com.lcwd.user.service.entities.Rating;

@SpringBootTest
class RatingServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingServices ratingServices;

	
//		 @Test
//	    void createRating() {
//			 
//			 Rating rating =Rating.builder().ratings(10).userId("").hotelId("").feedback("this is customised using feign client ").build();
//			 Rating SavedRating = ratingServices.create(rating);
//        Rating rating = Rating.builder().ratings(10).userId("").hotelId("").feedback("this is created using feign client").build();
//	       Rating savedRating = ratingServices.createratings(rating);	     
//	        System.out.println("new rating created");
//	    }
	

}
