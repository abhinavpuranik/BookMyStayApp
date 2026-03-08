/*
 * @author Developer
 * @version 6.0
 * Utility to manage reservation history
 * 
 */


package com.seveneleven.utility;
import java.util.ArrayList;
import java.util.List;

import com.seveneleven.model.Reservation;
public class BookingHistoryService {

		private List<Reservation> reservationHistory = new ArrayList<>();
		
		public void addReservation(Reservation reservation) {
			reservationHistory.add(reservation);
			
		}
		
		 public void showAllReservations() {

		        if (reservationHistory.isEmpty()) {
		            System.out.println("No reservations found.");
		            return;
		        }

		        System.out.println("\n--- BOOKING HISTORY ---");

		        for (Reservation r : reservationHistory) {
		            System.out.println(r);
		        }
		    }
		 
		 public void cancelReservation(String reservationId) {

		        Reservation found = null;

		        for (Reservation r : reservationHistory) {
		            if (r.getReservationId().equals(reservationId)) {
		                found = r;
		                break;
		            }
		        }

		        if (found == null) {
		            System.out.println("Reservation not found.");
		            return;
		        }

		        reservationHistory.remove(found);

		        System.out.println("Reservation cancelled: " + reservationId);
		    }
		 
		 
		
}
