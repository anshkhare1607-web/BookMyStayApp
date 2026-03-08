package com.service;

import com.model.Service;
import com.repository.AddOnRepository;
import java.util.List;

public class AddOnManagerServiceImpl implements AddOnManagerService {

    private final AddOnRepository addOnRepository;

    public AddOnManagerServiceImpl(AddOnRepository addOnRepository) {
        this.addOnRepository = addOnRepository;
    }

    //Override
    public void addService(String reservationId, String serviceName, double price) {
        if (reservationId == null || reservationId.trim().isEmpty()) {
            System.out.println("Error: Reservation ID cannot be empty");
            return;
        }
        Service service = new Service(serviceName, price);
        addOnRepository.addServiceToReservation(reservationId, service);
        System.out.println("Success: Added '" + serviceName + "' to Reservation ID: " + reservationId);
    }

    //Override
    public List<Service> getServices(String reservationId) {
        return addOnRepository.getServicesForReservation(reservationId);
    }

    //Override
    public double calculateTotalAddOnCost(String reservationId) {
        return getServices(reservationId).stream()
                .mapToDouble(Service::getPrice)
                .sum();
    }

    //Override
    public void displayServices(String reservationId) {
        List<Service> services = getServices(reservationId);
        if (services.isEmpty()) {
            System.out.println("No add-on services found for Reservation ID: " + reservationId);
            return;
        }

        System.out.println("\n---Add-On Services for Reservation---");
        for (Service s : services) {
            System.out.printf("- %-15s : Rs%.2f%n", s.getName(), s.getPrice());
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Total Additional Cost: Rs%.2f%n", calculateTotalAddOnCost(reservationId));
    }
}