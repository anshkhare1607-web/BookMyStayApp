package com.repository;

//for storing reservations

import com.model.*;
import java.util.*;

public class InMemoryBookingRepository implements BookingRepository{
	private final Queue<Reservation> bookingQueue = new LinkedList<>();
	
	//Override
	public void enqueue(Reservation reservation) {
		bookingQueue.offer(reservation);
	}
	
	//Override
	public Reservation dequeue() {
		return bookingQueue.poll();
	}
	
	//Override
	public Queue<Reservation> getQueue(){
		return new LinkedList<>(bookingQueue); //returns a copy to prevent direct changes
	}
	
	//Override
	public boolean isEmpty() {
		return bookingQueue.isEmpty();
	} 
}
