package com.service;


//methods for booking 
public interface BookingQueueService {

	void submitBookingRequest(String username, String roomType);
	void processingNextBooking();
	void displayQueue();
}
