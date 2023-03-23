package com.revature.exception;

public class UnauthorizedBlankResponseException extends Exception {

    public UnauthorizedBlankResponseException() {

        super("You are trying to input a response that is outside the parameters.");
    }

}