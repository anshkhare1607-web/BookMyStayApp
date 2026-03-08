package com.repository;

import com.model.*;
import java.util.List;

//interface for reporting
public interface ReportingRepository {

	void saveConfirmedReservation(Reservation reservation);
	List<Reservation> getAllReservations();
	
}
