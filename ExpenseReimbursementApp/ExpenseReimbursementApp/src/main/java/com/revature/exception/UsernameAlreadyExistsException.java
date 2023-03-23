package com.revature.exception;

public class UsernameAlreadyExistsException extends Exception{

    public UsernameAlreadyExistsException() {

        super("You are trying to input a username that already exists. Please choose another.");
    }

}
