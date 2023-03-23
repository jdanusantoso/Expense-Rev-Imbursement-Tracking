package com.RevUp.Exceptions;

public class InvalidReleaseYearInputException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidReleaseYearInputException() {
		
		super("Invalid year. Please enter a year after 2012.");
		
	}

	
}


