package com.lcwd.rating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_ratings")
public class Ratings {
	@Id
	private String ratingId;
	private String userId;
	private int ratings;
	private String hotelId;
	private String feedback;
}
