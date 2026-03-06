package com.controller;

import com.exception.*;
import com.model.*;
import com.service.*;

import java.util.Scanner;


//Admin controller class for all the admin features.
public class AdminController {

    private final InventoryService inventoryService;
    private final Scanner sc;

    //inventory services loading
    public AdminController(InventoryService inventoryService, Scanner scanner) {
        this.inventoryService = inventoryService;
        this.sc = scanner; 
    }

    //Application start
    public void start(User adminUser) {
        boolean running = true;
        System.out.println("\nWelcome " + adminUser.getUsername());
        
        while (running) {
            printMenu();
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        handleAddRoomType();
                        break;
                    case "2":
                        handleUpdateCount();
                        break;
                    case "3":
                        handleUpdatePrice();
                        break;
                    case "4":
                        inventoryService.displayRealTimeAvailabilty();
                        break;
                    case "5":
                        running = false;
                        System.out.println("Logging out Admin");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (RoomNotFoundException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //menu 
    private void printMenu() {
        System.out.println("\n=== Admin Console ===");
        System.out.println("1. Add Room Type");
        System.out.println("2. Update Room Inventory Count");
        System.out.println("3. Update Room Price");
        System.out.println("4. View Real-Time Availability");
        System.out.println("5. Logout");
        System.out.print("Select an option: ");
    }

    //Adding rooms
    private void handleAddRoomType() {
        System.out.print("Enter Room Type (e.g., Single/Double/Suite): ");
        String type = sc.nextLine();
        
        System.out.print("Enter Initial Available Count: ");
        int count = sc.nextInt();
        
        System.out.print("Enter Price Per Night: ");
        double price = sc.nextDouble();
        
        inventoryService.setupRoomType(type, count, price);
    }
    

    //updating room count
    private void handleUpdateCount() {
        System.out.print("Enter Room Type to update count: ");
        String type = sc.nextLine();
        
        System.out.print("Enter new Available Count: ");
        int count = sc.nextInt();
        
        inventoryService.updateInventoryCount(type, count);
    }

    //updating room price
    private void handleUpdatePrice() {
        System.out.print("Enter Room Type to update price: ");
        String type = sc.nextLine();
        
        System.out.print("Enter new Price Per Night: ");
        double price = sc.nextDouble();
        
        inventoryService.updateInventoryPrice(type, price);
    }
}