package com.exception;

// For handling the error if there is no room found

public class AuthenticationException extends RuntimeException{
	public AuthenticationException(String message) {
		super(message);
	}
	

}
