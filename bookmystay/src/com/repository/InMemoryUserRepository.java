package com.repository;
import java.util.*;
import com.model.*;


//Adding users
public class InMemoryUserRepository implements UserRepository {
    
    private final Map<String, User> users = new HashMap<>();

    //Override 
    public void save(User user) {
    	users.put(user.getUsername(), user);
    }
     
    //Override
    public User findByUsername(String username) {
    	return users.get(username);
    } 
    
    //Override
    public boolean existsByUsername(String username) {
    	return users.containsKey(username); 
    }

    
    
}
