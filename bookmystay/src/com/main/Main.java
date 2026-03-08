/*
 * Use Case 05 : Add-On Service Selection
 * 
 * @author : Developer
 * version : 5.0
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

		UserRepository userRepo = new InMemoryUserRepository();  //User Repository
		AuthService authService = new AuthServiceImpl(userRepo); //Authentication service
		
		BookingRepository bookingRepo = new InMemoryBookingRepository(); //Booking repo
		BookingQueueService bookingQueueService =  new BookingQueueServiceImpl(bookingRepo,inventoryRepo); //Booking service
		
		AddOnRepository addOnRepo = new InMemoryAddOnRepository(); // Add on service repo
		AddOnManagerService addOnManagerService = new AddOnManagerServiceImpl(addOnRepo); // Add on service 

		Scanner sc = new Scanner(System.in);
		MainController app = new MainController(authService, inventoryService, searchService,bookingQueueService,addOnManagerService, sc);
		app.start(); //App starting

	}
}