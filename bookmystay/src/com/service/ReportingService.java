package com.service;

import com.model.Reservation;

public interface ReportingService {

	void recordBooking(Reservation reservation);
	void generateBookingReport();
}
