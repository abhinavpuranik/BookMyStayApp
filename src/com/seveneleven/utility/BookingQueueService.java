
/*
 * @author Developer
 * @version 4.0
 * Utility to manage the booking queue
 */

package com.seveneleven.utility;

import java.util.LinkedList;
import java.util.Queue;

import com.seveneleven.model.*;

public class BookingQueueService {

		private Queue<Reservation> bookingQueue = new LinkedList<>();
		
		public void addBookingRequest(Reservation reservation) {
			bookingQueue.offer(reservation);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Booking request added to queue.");
		}
		
		public void processNextRequest(InventoryService inventory) {

		    Reservation reservation = bookingQueue.poll();

		    if (reservation == null) {
		        System.out.println("No pending booking requests.");
		        return;
		    }

		    String roomType = reservation.getRoomType();

		    String roomId = inventory.allocateRoom(roomType);

		    if (roomId == null) {
		        System.out.println("Booking failed for " + reservation.getGuestName());
		        System.out.println("No rooms available.");
		        return;
		    }

		    System.out.println("Reservation confirmed!");
		    System.out.println("Guest: " + reservation.getGuestName());
		    System.out.println("Room Type: " + roomType);
		    System.out.println("Assigned Room ID: " + roomId);
		}
		
		
		public void showQueue() {
			if(bookingQueue.isEmpty()) {
				System.out.println("Queue is empty");
				return;
			}
			
			System.out.println("Current queue : ");
			for(Reservation r : bookingQueue) {
				System.out.println(r);
			}
		}
		
}
