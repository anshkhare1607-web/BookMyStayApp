/*
 * Use Case 02 : Admin adding rooms and Customers searching the available rooms
 * 
 * @author : Developer
 * version : 2.0
 */
package com.main;

import com.controller.*;
import com.repository.*;
import com.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Dependencies
    	InventoryRepository inventoryRepo = new InMemoryInventoryRepository(); // Inventory
        InventoryService inventoryService = new InventoryServiceImpl(inventoryRepo); //Inventory service implementation
        SearchService searchService = new SearchServiceImpl(inventoryRepo); //Searching for rooms
        
        UserRepository userRepo = new InMemoryUserRepository(); 
        AuthService authService = new AuthServiceImpl(userRepo); 

        try (Scanner scanner = new Scanner(System.in)) {
            MainController app = new MainController(authService, inventoryService, searchService, scanner);
            app.start();
        }
    }
}