
package com.repository;

import java.util.*;

public class InMemoryInventoryRepository implements InventoryRepository {
    
    private final Map<String, Integer> roomCounts = new HashMap<>();
    private final Map<String, Double> roomPrices = new HashMap<>();
    private final Map<String,Set<String>> assignedRooms = new HashMap<>();

    //Override
    public void addRoomType(String roomType, int count, double price) {
        roomCounts.put(roomType, count);
        roomPrices.put(roomType, price);
        assignedRooms.putIfAbsent(roomType, new HashSet<>());
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
    
    //Override
    public boolean allocatedRoomId(String roomType,String roomId) {
    	Set<String> rooms = assignedRooms.getOrDefault(roomType, new HashSet<>());
    	//preventing duplicates
    	if(rooms.contains(roomId)) {
    		return false;
    	}
    	rooms.add(roomId);
    	assignedRooms.put(roomType, rooms);
    	return true;
    	
    }
    
    //Override
    public Set<String> getAssignedRooms(String roomType){
    	return Collections.unmodifiableSet(assignedRooms.getOrDefault(roomType, new HashSet<>()));
    }
    
    
    
    
    
    
    
    
    
}
