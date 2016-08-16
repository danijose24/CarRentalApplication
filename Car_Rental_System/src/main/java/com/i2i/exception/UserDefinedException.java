package com.i2i.exception;

public class UserDefinedException extends Exception{
	
	public UserDefinedException(String message) {
	    super (message);
	}

	public UserDefinedException(String message, Throwable exception) {
	    super (message, exception);
    }
}
