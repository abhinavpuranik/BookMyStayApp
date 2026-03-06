
/*
 * @author Developer
 * @version 1.0
 * 
 * Inventory management utility
 */


package com.seveneleven.utility;
import java.util.HashMap;
import com.seveneleven.model.*;
import java.util.Map;


public class InventoryService {
	
	private Map<String, Room> inventory = new HashMap<>();
	
	public void addRoomType(String type, int count, double price) {
		if(inventory.containsKey(type)) {
			System.out.println("Room type aalready exists");
			return;
		}
		Room room = new Room(type, count, price);
		inventory.put(type, room);
		
		System.out.println(type + " Room added successfully");
	}
	
	public void updateRoomCount(String type, int newCount) {
		Room room = inventory.get(type);
		
		if(room == null) {
			System.out.println("Room type not found.");
			return;
		}
		
		room.setAvailableCount(newCount);
		System.out.println("Count for " + type + " set as " + newCount);
		
	}
	
	public void updateRoomPrice(String type, double newPrice) {
		Room room = inventory.get(type);
		
		if(room == null) {
			System.out.println("Room type not found.");
			return;
		}
		
		room.setPricePerNight(newPrice);
		System.out.println("Price for " + type+ " set as " + newPrice);
		
	}
	
	public void displayInventory() {
		if(inventory.isEmpty()) {
			System.out.println("Inventory is empty");
			return;
		}
		
		for(Room room : inventory.values()) {
			System.out.println(room);
		}
	}
	
	public int getAvailability(String type) {
		Room room = inventory.get(type);
		return room == null ? 0 : room.getAvailableCount();
	}
	
	
	
	
	
	
}
