package com.service;

import com.model.*;
import java.util.*;

public interface AddOnManagerService {
    void addService(String reservationId, String serviceName, double price);
    List<Service> getServices(String reservationId);
    double calculateTotalAddOnCost(String reservationId);
    void displayServices(String reservationId);
}