package com.model;

//For handling reservations

public class Reservation {
	
	private final String username;
	private final String roomType;
	private String allocatedRoomId;

	
	
	public Reservation(String username,String roomType) {
		
		this.username = username;
		this.roomType = roomType;
	}
	
	public String getAllocatedRoomId() {
		return allocatedRoomId; 
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setAllocatedRoomId(String allocatedRoom) {
		this.allocatedRoomId = allocatedRoomId;  
	}
	
	//Override
	public String toString() {
		return "Reservation request : User = "+username+" | Room Type : "+roomType+" | Allocated Room Id : "+allocatedRoomId;
	}
	
	
	

}
