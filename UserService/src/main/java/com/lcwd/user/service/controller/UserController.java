package com.lcwd.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController	{
	@Autowired
	private UserServices userServices;
	Logger logger =LoggerFactory.getLogger(UserController.class);

	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
//	find by single user id .
	int retryCount = 1;
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name= "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		logger.info("get Single User Handler : UserController ");
		logger.info("retry count: {}",retryCount);
		retryCount++;
		User user = userServices.getUser(userId);
		return ResponseEntity.ok(user);
	}
//creating fallback methhod for circuitbreaker .
	public ResponseEntity<User> ratingHotelFallback(String	userId, Exception ex){
		logger.info("fallback is exicuted bcoz Service is down",ex.getMessage());
		User user = User.builder().email("abhay@gmail.com").name("Dummy").about("This is dammy bcoz some service is down").userId("4654").build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
// All user get . 
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userServices.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
