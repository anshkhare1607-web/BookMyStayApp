package com.repository;
import com.model.*;

public interface UserRepository {
	
	void save(User user);
	User findByUsername(String username);
	boolean existsByUsername(String username);
	

}
