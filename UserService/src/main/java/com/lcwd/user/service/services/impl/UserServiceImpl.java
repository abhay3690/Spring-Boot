 package com.lcwd.user.service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptiopn.ResourceNotFoundException;
import com.lcwd.user.service.externel.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	public User getUser(String UserId) {
		User user = userRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given Id " + UserId));
//		 fetch the rating of the above user from RATING SERVICE

		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);
		logger.info("Response rating offer {}", ratingsOfUser);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {
			// api call to hotel service to get the hotel
			// localhost:8082/hotels/9b98690a-7fc9-46c1-ae5d-76c09cab9f7d
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());

			rating.setHotel(hotel);

			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);

		return user;
	}

}
