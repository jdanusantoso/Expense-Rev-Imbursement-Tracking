package com.revature.dao;

import com.revature.exception.CannotUpdateException;
import com.revature.exception.TicketDoesNotExistException;
import com.revature.models.Ticket;

import java.util.List;

public interface TicketDao {

    //Employee Ticket Methods

    Ticket createNewTicket(Ticket t);

    List<Ticket> viewAllEmployeeSubmittedTickets(String ticket_submitter);

    //List<Ticket> viewAllEmployeeSubmittedTickets(Employee e);

    //Manager Ticket Methods

    List<Ticket> viewAllSubmittedTickets();

    Ticket getByTicketID(int ticket_id) throws TicketDoesNotExistException ;

    boolean updateTicketStatus (String ticket_status, int ticket_id) throws CannotUpdateException;

    List<Ticket> viewAllPendingTickets(String ticket_status);












}