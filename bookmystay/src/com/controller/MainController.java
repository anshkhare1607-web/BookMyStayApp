package com.controller;

import com.exception.*;
import com.model.*;
import com.service.*;

import java.util.Scanner;

//Main controller class for admin and customer

public class MainController {
    private final AuthService authService;
    private final AdminController adminController;
    private final CustomerController customerController;
    private final Scanner sc;

    public MainController(AuthService authService, InventoryService inventoryService, SearchService searchService,BookingQueueService bookingQueueService,
    		AddOnManagerService addOnManagerService,ReportingService reportingService, Scanner scanner) {
        this.authService = authService;
        this.adminController = new AdminController(inventoryService,bookingQueueService, reportingService,scanner);
        this.customerController = new CustomerController(searchService,bookingQueueService,addOnManagerService, scanner); 
        this.sc = scanner;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== BookMyStay Login System ===");
            System.out.println("1. Login");
            System.out.println("2. Register (Customer)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        handleLogin(); //admin login
                        break;
                    case "2":
                        handleRegister(); //Customer registration
                        break;
                    case "3":
                        running = false;
                        System.out.println("Shutting down");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (AuthenticationException | UserAlreadyExistsException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //login method
    private void handleLogin() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = authService.login(username, password); //authenticating the admin login credentials

        if (user.getRole() == Role.ADMIN) {
            adminController.start(user);
        } else if (user.getRole() == Role.CUSTOMER) {
            customerController.start(user);
        }
    }

    private void handleRegister() { //registering new customer
        System.out.print("Enter new Username: ");
        String username = sc.nextLine();
        System.out.print("Enter new Password: ");
        String password = sc.nextLine();

        authService.registerCustomer(username, password);
    }
}