/*
 * @author Developer
 * @version 1.0
 * Inventory management utility
 */

package com.seveneleven.utility;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<String, Integer> roomCount;
    private Map<String, Double> roomPrice;

    public InventoryService() {
        roomCount = new HashMap<>();
        roomPrice = new HashMap<>();
    }

  
    public void addRoomType(String type, int count, double price) {
        roomCount.put(type, count);
        roomPrice.put(type, price);
        System.out.println(type + " room added successfully.");
    }

  
    public void updateRoomCount(String type, int newCount) {
        if(roomCount.containsKey(type)) {
            roomCount.put(type, newCount);
            System.out.println("Room count updated for " + type);
        } else {
            System.out.println("Room type does not exist.");
        }
    }

   
    public void updatePrice(String type, double newPrice) {
        if(roomPrice.containsKey(type)) {
            roomPrice.put(type, newPrice);
            System.out.println("Price updated for " + type);
        } else {
            System.out.println("Room type does not exist.");
        }
    }

  
    public void showInventory() {
        System.out.println("\nCurrent Room Inventory:");

        for(String type : roomCount.keySet()) {
            int count = roomCount.get(type);
            double price = roomPrice.get(type);

            System.out.println(type + " | Available: " + count + " | Price: " + price);
        }
    }
 
    public int getAvailability(String type) {
        return roomCount.getOrDefault(type, 0);
    }
    
    public void searchAvailableRooms() {
    	
    	System.out.println("\n--- AVAILABLE ROOMS ---");
    	
    	for(String type : roomCount.keySet()) {
    		
    		int count = roomCount.get(type);
    		
    		if(count > 0) {
    			double price = roomPrice.get(type);
    			System.out.println(type + " | Available: " + count + " | Price: " + price);
    		}
    	}
    }
    
    public boolean isRoomAvailable(String type) {
    	if(!roomCount.containsKey(type)) {
    		return false;
    	}
    	return roomCount.get(type) > 0;
    }
    
    public double getRoomPrice(String type) {
    	if(!roomPrice.containsKey(type)) {
    		System.out.println(type + " Does not exist");
    		return -1;
    	}
    	
    	return roomPrice.get(type);
    }
}