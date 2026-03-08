package com.service;

import com.model.Reservation;
import com.repository.ReportingRepository;
import java.util.List;

public class ReportingServiceImpl implements ReportingService {

    private final ReportingRepository reportingRepository; 

    public ReportingServiceImpl(ReportingRepository reportingRepository) {
        this.reportingRepository = reportingRepository;
    }

    //Override
    public void recordBooking(Reservation reservation) {
        reportingRepository.saveConfirmedReservation(reservation);
    }

    //Override
    public void generateBookingReport() {
        List<Reservation> history = reportingRepository.getAllReservations();
        
        if (history.isEmpty()) {
            System.out.println("No booking history available.");
            return;
        }

        System.out.println("\n--- Booking History---");
        System.out.printf("%-15s | %-15s | %-15s%n", "Username", "Room Type", "Room ID");
        System.out.println("---------------------------------------------------");
        for (Reservation res : history) {
            System.out.printf("%-15s | %-15s | %-15s%n", 
                    res.getUsername(), res.getRoomType(), res.getAllocatedRoomId());
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Total Confirmed Bookings: " + history.size());
    }
}