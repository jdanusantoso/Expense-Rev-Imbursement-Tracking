package com.revature.exception;

@SuppressWarnings("serial")

public class MissingRequiredTicketInformationException extends Exception {

    public MissingRequiredTicketInformationException() {

        super("You are submitting a ticket that does not have the required ticket submitter name, \n"
                + "expense description, and/or expense amount.");
    }

}



