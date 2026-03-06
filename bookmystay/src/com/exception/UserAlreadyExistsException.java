package com.exception;

//For handling the error if user already exists


public class UserAlreadyExistsException extends RuntimeException {
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
