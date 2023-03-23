package com.RevUp.Exceptions;

public class InputMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	public InputMismatchException() {
		
		super("Value must only contain letters.");
		
	}

	
}
