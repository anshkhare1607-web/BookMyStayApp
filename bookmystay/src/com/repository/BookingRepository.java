package com.repository;

import com.model.*;
import java.util.Queue;


//Interface for Booking 
public interface BookingRepository {

	void enqueue(Reservation reservation); //Adding reservation to the queue
	Reservation dequeue(); //Deleting reservations
	Queue<Reservation> getQueue(); //Getting reservation list
	boolean isEmpty(); //Checking if empty

}
