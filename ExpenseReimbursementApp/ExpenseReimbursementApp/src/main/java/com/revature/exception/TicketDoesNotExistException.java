package com.revature.exception;

public class TicketDoesNotExistException extends Exception {

    public TicketDoesNotExistException() {
        super("The ticket you are looking for does not exist.");
    }

}