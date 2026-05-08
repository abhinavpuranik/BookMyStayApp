/*
 * @author Developer
 * @version 5.0
 * Entrypoint
 */
package com.seveneleven.main;

import java.util.Scanner;

import com.seveneleven.utility.InventoryService;
import com.seveneleven.utility.BookingQueueService;
import com.seveneleven.utility.ServiceManagementModule;

import com.seveneleven.model.Reservation;
import com.seveneleven.model.Service;

public class HotelAdminApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService inventory = new InventoryService();
        BookingQueueService bookingQueue = new BookingQueueService();
        ServiceManagementModule serviceModule = new ServiceManagementModule();

        inventory.addRoomType("Single", 10, 3000);
        inventory.addRoomType("Double", 15, 5000);
        inventory.addRoomType("Suite", 5, 9000);

        // Pre-added booking requests (simulate traffic)
        bookingQueue.addBookingRequest(new Reservation("Alice", "Single"));
        bookingQueue.addBookingRequest(new Reservation("Bob", "Suite"));
        bookingQueue.addBookingRequest(new Reservation("Charlie", "Double"));

        while (true) {

            System.out.println("\n--- HOTEL SYSTEM MENU ---");
            System.out.println("1. Add Room Type (Admin)");
            System.out.println("2. Update Room Count (Admin)");
            System.out.println("3. Update Room Price (Admin)");
            System.out.println("4. View Inventory (Admin)");
            System.out.println("5. Search Available Rooms (Guest)");
            System.out.println("6. Check Room Availability (Guest)");
            System.out.println("7. Request Booking (Guest)");
            System.out.println("8. Process Next Booking (Admin)");
            System.out.println("9. View Booking Queue");
            System.out.println("10. Add Service to Reservation");
            System.out.println("11. View Services for Reservation");
            System.out.println("12. Calculate Service Cost");
            System.out.println("13. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter count: ");
                    int count = sc.nextInt();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    inventory.addRoomType(type, count, price);
                }

                case 2 -> {
                    System.out.print("Enter room type: ");
                    String type1 = sc.nextLine();

                    System.out.print("Enter new count: ");
                    int newCount = sc.nextInt();

                    inventory.updateRoomCount(type1, newCount);
                }

                case 3 -> {
                    System.out.print("Enter room type: ");
                    String type2 = sc.nextLine();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    inventory.updatePrice(type2, newPrice);
                }

                case 4 -> inventory.showInventory();

                case 5 -> inventory.searchAvailableRooms();

                case 6 -> {
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    if (inventory.isRoomAvailable(type)) {
                        double price = inventory.getRoomPrice(type);

                        System.out.println("Room available!");
                        System.out.println("Price per night: " + price);
                    } 
                    else {
                        System.out.println("Room not available.");
                    }
                }

                case 7 -> {
                    System.out.print("Enter guest name: ");
                    String guest = sc.nextLine();

                    System.out.print("Enter room type: ");
                    String roomType = sc.nextLine();

                    Reservation reservation = new Reservation(guest, roomType);

                    bookingQueue.addBookingRequest(reservation);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                case 8 -> bookingQueue.processNextRequest(inventory);

                case 9 -> bookingQueue.showQueue();

                case 10 -> {

                    System.out.print("Enter reservation ID: ");
                    String reservationId = sc.nextLine();

                    serviceModule.showAvailableServices();

                    System.out.print("Enter service name: ");
                    String serviceName = sc.nextLine();

                    Service service = serviceModule.createService(serviceName);

                    if (service == null) {
                        System.out.println("Invalid service.");
                    }
                    else {
                        serviceModule.addService(reservationId, service);
                    }
                }

                case 11 -> {
                    System.out.print("Enter reservation ID: ");
                    String reservationId = sc.nextLine();

                    serviceModule.showServices(reservationId);
                }

                case 12 -> {
                    System.out.print("Enter reservation ID: ");
                    String reservationId = sc.nextLine();

                    double cost = serviceModule.calculateServiceCost(reservationId);

                    System.out.println("Total additional service cost: " + cost);
                }

                case 13 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}