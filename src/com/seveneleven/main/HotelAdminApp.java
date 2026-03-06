/*
 * @author Developer
 * @version 1.0
 * Entrypoint
 */
package com.seveneleven.main;

import java.util.Scanner;

import com.seveneleven.utility.InventoryService;

public class HotelAdminApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 10, 3000);
        inventory.addRoomType("Double", 15, 5000);
        inventory.addRoomType("Suite", 5, 9000);

        while (true) {

            System.out.println("\n--- HOTEL SYSTEM MENU ---");
            System.out.println("1. Add Room Type (Admin)");
            System.out.println("2. Update Room Count (Admin)");
            System.out.println("3. Update Room Price (Admin)");
            System.out.println("4. View Inventory (Admin)");
            System.out.println("5. Search Available Rooms (Guest)");
            System.out.println("6. Check Room Availability (Guest)");
            System.out.println("7. Exit");

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
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}