package com.service;

import com.model.*;
import com.repository.*;
import java.util.*;

//Implementing methods for booking interface
public class BookingQueueServiceImpl implements BookingQueueService{

	private final BookingRepository bookingRepository;
	private final InventoryRepository inventoryRepository;
	private final ReportingService reportingService;

	public BookingQueueServiceImpl(BookingRepository bookingRepository, InventoryRepository inventoryRepository,ReportingService reportingService) {
		this.bookingRepository = bookingRepository;
		this.inventoryRepository = inventoryRepository;
		this.reportingService = reportingService;
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
			String roomId = roomType.substring(0,3).toUpperCase()+"-"+UUID.randomUUID().toString().substring(0,4);
			if(inventoryRepository.allocatedRoomId(roomType,roomId)) {
				inventoryRepository.updateRoomCount(roomType, availableCount - 1);
				request.setAllocatedRoomId(roomId);
				System.out.println("Processed: Booking confirmed for user '" + request.getUsername() + "' Assigned room Id :" + roomId);
			}
			
		} else {
			System.out.println("Processed: Booking failed for user '" + request.getUsername() + "'. Room Type '" + roomType + "' is out of inventory");
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
