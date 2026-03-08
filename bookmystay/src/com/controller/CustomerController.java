package com.controller;

import com.model.User;
import com.service.*;

import java.util.Scanner;

// customer controller
public class CustomerController {
    private final SearchService searchService; 
    private final BookingQueueService bookingQueueService;
    private final AddOnManagerService addOnManagerService;
    private final Scanner sc;

    public CustomerController(SearchService searchService,BookingQueueService bookingQueueService,AddOnManagerService addOnManagerService, Scanner sc) {
        this.searchService = searchService;
        this.bookingQueueService = bookingQueueService; 
        this.addOnManagerService = addOnManagerService;
        this.sc = sc;
    }

    public void start(User user) {
        boolean running = true;
        System.out.println("\nWelcome " + user.getUsername());
        
        while (running) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Submit Booking Request");
            System.out.println("3. Manage Add on Services");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");
            
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                	searchService.searchAvailableRooms(); //search available rooms
                    break;
                case "2": // Submit booking request
                	System.out.print("Enter the room type : ");
                	String roomType = sc.nextLine();
                	bookingQueueService.submitBookingRequest(user.getUsername(), roomType);
                	break;
                case "3":
                	handleAddOnServices();
                	break;
                case "4":
                    running = false;
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
            }
        }
    }
    
    private void handleAddOnServices() {
        System.out.print("Enter your Reservation ID (Allocated Room ID): ");
        String resId = sc.nextLine();

        System.out.println("\n--- Select an Add-On Service ---");
        System.out.println("A. Breakfast (Rs 25.0)");
        System.out.println("B. Bar (Rs 75.0)");
        System.out.println("C. Cab Service (Rs 240.0)");
        System.out.println("D. View My Added Services & Total Cost");
        System.out.print("Choice: ");
        
        String choice = sc.nextLine().toUpperCase();
        
        switch (choice) {
            case "A":
                addOnManagerService.addService(resId, "Breakfast", 25.0);
                break;
            case "B":
                addOnManagerService.addService(resId, "Bar", 75.0);
                break;
            case "C":
                addOnManagerService.addService(resId, "Cab Service", 240.0);
                break;
            case "D":
                addOnManagerService.displayServices(resId);
                break;
            default:
                System.out.println("Invalid service option.");
        }
    }
}
