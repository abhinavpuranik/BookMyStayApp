/*
 * @author Developer
 * @version 1.0
 * Room model 
 */

package com.seveneleven.model;

public class Room {
	
	private String type;
	private int availableCount;
	private double pricePerNight;
	
	public Room(String type, int availableCount, double pricePerNight) {
		this.type = type;
		this.availableCount = availableCount;
		this.pricePerNight = pricePerNight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	 @Override
	public String toString() {
	     return type + " | Available: " + availableCount + " | Price: " + pricePerNight;
	    }
	

}
