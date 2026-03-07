package com.service;

//Searching interface

public interface SearchService {

	void searchAvailableRooms(); //searching available rooms
	boolean isRoomAvailable(String roomType); // checking if rooms are available
}
