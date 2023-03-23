package com.revature.exception;

public class EmployeeDoesNotExistException extends Exception {


    public EmployeeDoesNotExistException() {

        super("The employee that is trying to login does not have an existing username and password.");
    }

}
