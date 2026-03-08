package com.repository;

import com.model.*;
import java.util.List;

public interface AddOnRepository {

	void addServiceToReservation(String reservationId, Service service);
	List<Service> getServicesForReservation(String reservationId); 

}
