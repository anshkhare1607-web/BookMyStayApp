package com.service;

//implementation of the SearchService Interface

import com.repository.*;
import java.util.*;

public class SearchServiceImpl implements SearchService{
	
	private final InventoryRepository inventoryRepository; 
	public SearchServiceImpl(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	//Override
	public void searchAvailableRooms() {
		Map<String, Integer> counts = inventoryRepository.getAllRoomCounts();
		Map<String,Double> prices = inventoryRepository.getAllRoomPrices();
		
		System.out.println("-----Room Search/Availabiluty-----");
		boolean availableRoomExists = false;
		for(String roomType : counts.keySet()) { //accessing roomTypes stored in keys
			int count = counts.get(roomType); // storing count of each roomTypes stored in values
			if(count > 0) {
				availableRoomExists = true;
				System.out.println("Room Type : "+roomType+" | Available : "+count+" | Price : "+prices.get(roomType));
			}
		}
		if(!availableRoomExists) {
			System.out.println("No room Available");
		}
	}
	
	//Override
	public boolean isRoomAvailable(String roomType) {
		Integer count = inventoryRepository.getAvailableCount(roomType);
		return count!=null && count>0;
		
	}
}
