package com.service;

import com.exception.*;
import com.repository.*;
import java.util.Map; 

//Implementing the inventory services

public class InventoryServiceImpl implements InventoryService { 

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    
    public void setupRoomType(String roomType, int initialCount, double initialPrice) {
        if (roomType == null || roomType.isEmpty()) {
            throw new IllegalArgumentException("Room type cannot be empty.");
        }
        if (initialCount < 0 || initialPrice < 0) {
            throw new IllegalArgumentException("Count and price must be non-negative.");
        }
        inventoryRepository.addRoomType(roomType, initialCount, initialPrice);
        System.out.println("Success: Room type '" + roomType + "' added to inventory.");
    }

    public void updateInventoryCount(String roomType, int newCount) {
        validateRoomExists(roomType);
        if (newCount < 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        }
        inventoryRepository.updateRoomCount(roomType, newCount);
        System.out.println("Success: Inventory count for '" + roomType + "' updated to " + newCount);
    }

    
    public void updateInventoryPrice(String roomType, double newPrice) {
        validateRoomExists(roomType);
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative."); 
        }
        inventoryRepository.updateRoomPrice(roomType, newPrice);
        System.out.println("Success: Price for '" + roomType + "' updated to " + newPrice);
    }

   
    
    public void displayRealTimeAvailabilty() {
        Map<String, Integer> counts = inventoryRepository.getAllRoomCounts();
        Map<String, Double> prices = inventoryRepository.getAllRoomPrices();

        if (counts.isEmpty()) {
            System.out.println("Inventory is currently empty.");
            return;
        }

        System.out.println("\n--- Real-Time Availability Status ---");
        for (String roomType : counts.keySet()) {
            System.out.println("Room Type: " + roomType + " | Available Count: " + counts.get(roomType) + " | Price per Night: Rs" + prices.get(roomType));
        }
    }

    private void validateRoomExists(String roomType) {
        if (!inventoryRepository.roomTypeExists(roomType)) {
            throw new AuthenticationException("Room type '" + roomType + "' does not exist in inventory.");
        }
    }
}