/*
 * Use Case 01 : Room Inventory Setup & Management
 * 
 * @author : Developer
 * version : 1.0
 */
package com.main;

import com.controller.*;
import com.repository.*;
import com.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Dependencies
    	InventoryRepository inventoryRepo = new InMemoryInventoryRepository(); 
        InventoryService inventoryService = new InventoryServiceImpl(inventoryRepo);
        
        UserRepository userRepo = new InMemoryUserRepository(); 
        AuthService authService = new AuthServiceImpl(userRepo); 

        try (Scanner scanner = new Scanner(System.in)) {
            MainController app = new MainController(authService, inventoryService, scanner);
            app.start();
        }
    }
}