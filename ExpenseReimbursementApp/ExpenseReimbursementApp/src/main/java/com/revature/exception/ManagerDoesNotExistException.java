package com.revature.exception;

public class ManagerDoesNotExistException extends Exception {


    public ManagerDoesNotExistException() {

        super("The manager that is trying to login does not have an existing username and password.");
    }

}