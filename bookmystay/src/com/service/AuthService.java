package com.service;
import com.model.*;

public interface AuthService {
	
	User login(String username, String password);
	void registerCustomer(String username, String password);

}
