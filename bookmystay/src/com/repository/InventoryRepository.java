package com.repository;
import java.util.Map;

//Interface for creating different inventory methods

public interface InventoryRepository {
	
	void addRoomType(String roonType, int count, double price);
	void updateRoomCount(String roomType, int newCount);
	void updateRoomPrice(String roomType, double newPrice);
	Integer getAvailableCount(String roomType);
	Double getRoomPrice(String roomType);
	Map<String, Double> getAllRoomPrices();
	Map<String, Integer> getAllRoomCounts(); 

	boolean roomTypeExists(String roomType); 

	
}
