package com.revature.exception;

public class CannotUpdateException extends Exception {

    public CannotUpdateException() {

        super("You are trying to update an unchangeable field.");
    }

}
