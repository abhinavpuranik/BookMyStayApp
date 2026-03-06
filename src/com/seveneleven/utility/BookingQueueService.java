
/*
 * @author Developer
 * @version 3.0
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
		
		public void processNextRequest() {
			
			if(bookingQueue.isEmpty()) {
				System.out.println("No pending requests");
				return;
			}
			Reservation reservation = bookingQueue.poll();
			
			
			System.out.println("Processing booking request:");
			System.out.println(reservation);
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
