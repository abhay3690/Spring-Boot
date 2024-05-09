package com.lcwd.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

	private String rattingId;
	private String userId;
	private String hotelId;
	private int ratings;
	private String feedback;
	private  Hotel hotel;
	

}
