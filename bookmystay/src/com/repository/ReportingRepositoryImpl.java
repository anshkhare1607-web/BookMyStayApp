package com.repository;

import com.model.*;
import java.util.*;

public class ReportingRepositoryImpl implements ReportingRepository{

	private final List<Reservation> history = new ArrayList<>();
	
	//Override
	public void saveConfirmedReservation(Reservation reservation) {
		history.add(reservation);
	}
	
	//Override
	public List<Reservation> getAllReservations(){
		return Collections.unmodifiableList(history);
	}
}
