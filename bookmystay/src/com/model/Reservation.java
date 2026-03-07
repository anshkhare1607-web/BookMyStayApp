package com.model;

//For handling reservations

public class Reservation {
	
	private final String username;
	private final String roomType;
	
	public Reservation(String username,String roomType) {
		this.username = username;
		this.roomType = roomType;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	//Override
	public String toString() {
		return "Reservation request : User = "+username+" | Room Type : "+roomType;
	}
	
	
	

}
