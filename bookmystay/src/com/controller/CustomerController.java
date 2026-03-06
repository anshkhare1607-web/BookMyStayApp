package com.controller;

import com.model.User;
import com.service.InventoryService;
import java.util.Scanner;


// customer controller
public class CustomerController {
    private final InventoryService inventoryService; //object for inventory service.
    private final Scanner sc;

    public CustomerController(InventoryService inventoryService, Scanner sc) {
        this.inventoryService = inventoryService;
        this.sc = sc;
    }

    public void start(User user) {
        boolean running = true;
        System.out.println("\nWelcome " + user.getUsername());
        
        while (running) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Logout");
            System.out.print("Select an option: ");
            
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    inventoryService.displayRealTimeAvailabilty(); //current available rooms
                    break;
                case "2":
                    running = false;
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
            }
        }
    }
}
