package com.repository;

import com.model.*;
import java.util.*;

public class InMemoryAddOnRepository implements AddOnRepository {
    
    // Map<String, List<Service>> - reservation ID - services
    private final Map<String, List<Service>> reservationServices = new HashMap<>();

    //Override
    public void addServiceToReservation(String reservationId, Service service) {
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);
    }

    //Override
    public List<Service> getServicesForReservation(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }
}