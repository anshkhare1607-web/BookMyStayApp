
package com.repository;

import java.util.*;

public class InMemoryInventoryRepository implements InventoryRepository {
    
    private final Map<String, Integer> roomCounts = new HashMap<>();
    private final Map<String, Double> roomPrices = new HashMap<>();

    //Override
    public void addRoomType(String roomType, int count, double price) {
        roomCounts.put(roomType, count);
        roomPrices.put(roomType, price);
    }

    //Override
    public void updateRoomCount(String roomType, int newCount) {
        roomCounts.put(roomType, newCount);
    }

    //Override
    public void updateRoomPrice(String roomType, double newPrice) {
        roomPrices.put(roomType, newPrice);
    }

    //Override
    public Integer getAvailableCount(String roomType) {
        return roomCounts.get(roomType);
    }

    //Override
    public Double getRoomPrice(String roomType) {
        return roomPrices.get(roomType);
    }

    //Override
    public Map<String, Integer> getAllRoomCounts() {
        return Collections.unmodifiableMap(roomCounts);
    }

    //Override
    public Map<String, Double> getAllRoomPrices() {
        return Collections.unmodifiableMap(roomPrices);
    }

    //Override
    public boolean roomTypeExists(String roomType) {
        return roomCounts.containsKey(roomType);
    }
}
