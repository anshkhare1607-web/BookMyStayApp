package com.service;

import com.model.*;
import com.repository.*;
import java.util.*;

//Implementing methods for booking interface
public class BookingQueueServiceImpl implements BookingQueueService{

	private final BookingRepository bookingRepository;
	private final InventoryRepository inventoryRepository;

	public BookingQueueServiceImpl(BookingRepository bookingRepository, InventoryRepository inventoryRepository) {
		this.bookingRepository = bookingRepository;
		this.inventoryRepository = inventoryRepository;
	}


	//Override
	public void submitBookingRequest(String username, String roomType) {
		if (!inventoryRepository.roomTypeExists(roomType)) {
			System.out.println("Error: Room type does not exist");
			return;
		}
		Reservation reservation = new Reservation(username, roomType);
		bookingRepository.enqueue(reservation);
		System.out.println("Success: Booking request submitted and enqueued for " + roomType);
	}

	//Override
	public void processingNextBooking() {
		//if booking queue is empty, return
		if (bookingRepository.isEmpty()) {
			System.out.println("The booking queue is currently empty");
			return;
		}

		Reservation request = bookingRepository.dequeue();
		String roomType = request.getRoomType();
		Integer availableCount = inventoryRepository.getAvailableCount(roomType);

		if (availableCount != null && availableCount > 0) {
			inventoryRepository.updateRoomCount(roomType, availableCount - 1);
			System.out.println("Processed: Booking confirmed for user '" + request.getUsername() + "' for room '" + roomType);
		} else {
			System.out.println("Processed: Booking failed for user '" + request.getUsername() + "'. Room '" + roomType + "' is out of inventory");
		}
	}

	//Override
	public void displayQueue() {
		Queue<Reservation> queue = bookingRepository.getQueue();
		if (queue.isEmpty()) {
			System.out.println("Booking queue is empty.");
			return;
		}

		System.out.println("\n--- Current Booking Queue ---");
		int position = 1;
		for (Reservation res : queue) {
			System.out.println(position + ". User: " + res.getUsername() + " | Room: " + res.getRoomType());
			position++;
		}
		System.out.println("-----------------------------");
	}

}
