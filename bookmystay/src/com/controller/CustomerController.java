package com.controller;

import com.model.User;
import com.service.*;

import java.util.Scanner;

// customer controller
public class CustomerController {
    private final SearchService searchService; //object for inventory service.
    private final BookingQueueService bookingQueueService;
    private final Scanner sc;

    public CustomerController(SearchService searchService,BookingQueueService bookingQueueService, Scanner sc) {
        this.searchService = searchService;
        this.bookingQueueService = bookingQueueService; 
        this.sc = sc;
    }

    public void start(User user) {
        boolean running = true;
        System.out.println("\nWelcome " + user.getUsername());
        
        while (running) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Submit Booking Request");
            System.out.println("3. Logout");
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
                    running = false;
                    System.out.println("Logging out");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
            }
        }
    }
}
