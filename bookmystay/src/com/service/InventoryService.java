package com.service;


public interface InventoryService {

		void setupRoomType(String roomType, int initialCount, double initialPrice);
		void updateInventoryCount(String roomType, int newCount);
		void updateInventoryPrice(String roomType, double newPrice);
		void displayRealTimeAvailabilty();
		
}
