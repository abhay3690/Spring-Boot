package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelService {
	Hotel create (Hotel hotel);
	List<Hotel> getAll();
	Hotel get(String id);
	
}
