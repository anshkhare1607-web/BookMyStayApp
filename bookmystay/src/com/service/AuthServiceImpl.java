package com.service;


import com.exception.*;
import com.model.*;
import com.repository.*;


//implementing the auth service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    // Hard-coded admin credentials as requested
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Override
    //Logging in admin
    public User login(String username, String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return new User(username, password, Role.ADMIN);
        }

        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        throw new AuthenticationException("Invalid username or password.");
    }

    //Override
    //Customer registration
    public void registerCustomer(String username, String password) {
        if (ADMIN_USERNAME.equals(username) || userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException("Username '" + username + "' is already taken.");
        }
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty.");
        }

        User newUser = new User(username.trim(), password.trim(), Role.CUSTOMER);
        userRepository.save(newUser);
        System.out.println("Success: Customer registered successfully.");
    }
}