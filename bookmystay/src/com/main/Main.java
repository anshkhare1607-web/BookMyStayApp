/*
 * Use Case 02 : Booking Request from Customers on the first come first serve basis
 * 
 * @author : Developer
 * version : 3.0
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

		Scanner sc = new Scanner(System.in);
		MainController app = new MainController(authService, inventoryService, searchService,bookingQueueService, sc);
		app.start(); //App starting

	}
}