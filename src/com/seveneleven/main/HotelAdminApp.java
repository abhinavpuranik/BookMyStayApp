
/*
 * @author Developer
 * @version 1.0
 * 
 * Entrypoint 
 */

package com.seveneleven.main;

import com.seveneleven.utility.*;
import java.util.Scanner;

public class HotelAdminApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryService inventory = new InventoryService();

        // Initializing default rooms
        inventory.addRoomType("Single", 10, 3000);
        inventory.addRoomType("Double", 15, 5000);
        inventory.addRoomType("Suite", 5, 9000);

        while (true) {

            System.out.println("\n--- HOTEL INVENTORY MENU ---");
            System.out.println("1. Add Room Type");
            System.out.println("2. Update Room Count");
            System.out.println("3. Update Price");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter room count: ");
                    int count = sc.nextInt();

                    System.out.print("Enter price per night: ");
                    double price = sc.nextDouble();

                    inventory.addRoomType(type, count, price);
                }

                case 2 -> {
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter new count: ");
                    int count = sc.nextInt();

                    inventory.updateRoomCount(type, count);
                }

                case 3 -> {
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter new price: ");
                    double price = sc.nextDouble();

                    inventory.updateRoomPrice(type, price);
                }

                case 4 -> inventory.displayInventory();

                case 5 -> {
                    System.out.println("Exiting system.");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}