package com.lcwd.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.entities.Ratings;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, String> {
//custom finder methods

	List<Ratings> findByUserId(String userId);

	List<Ratings> findByHotelId(String hotelId);
}
