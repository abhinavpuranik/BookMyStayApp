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

    // Add a new room type
    public void addRoomType(String type, int count, double price) {
        roomCount.put(type, count);
        roomPrice.put(type, price);
        System.out.println(type + " room added successfully.");
    }

    // Update room count
    public void updateRoomCount(String type, int count) {
        if(roomCount.containsKey(type)) {
            roomCount.put(type, count);
            System.out.println("Room count updated for " + type);
        } else {
            System.out.println("Room type does not exist.");
        }
    }

    // Update price
    public void updatePrice(String type, double price) {
        if(roomPrice.containsKey(type)) {
            roomPrice.put(type, price);
            System.out.println("Price updated for " + type);
        } else {
            System.out.println("Room type does not exist.");
        }
    }

    // Show inventory
    public void showInventory() {
        System.out.println("\nCurrent Room Inventory:");

        for(String type : roomCount.keySet()) {
            int count = roomCount.get(type);
            double price = roomPrice.get(type);

            System.out.println(type + " | Available: " + count + " | Price: " + price);
        }
    }

    // Check availability
    public int getAvailability(String type) {
        return roomCount.getOrDefault(type, 0);
    }
}