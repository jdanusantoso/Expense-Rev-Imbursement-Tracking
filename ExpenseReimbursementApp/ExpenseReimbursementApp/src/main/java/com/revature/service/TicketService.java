package com.revature.service;

import com.revature.dao.TicketDao;
import com.revature.exception.CannotUpdateException;
import com.revature.exception.MissingRequiredTicketInformationException;
import com.revature.exception.TicketDoesNotExistException;
import com.revature.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private TicketDao ticketDao;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket createNewTicket(String ticket_name, int expense_date, String expense_description, Double expense_amount, String ticket_submitter, int
            expense_Type_fk, String ticket_status) throws MissingRequiredTicketInformationException {


        if (expense_description.isEmpty() || ticket_submitter.isEmpty() || expense_amount <= 0.00) {
            throw new MissingRequiredTicketInformationException();

        } else {
            System.out.println("The ticket does have a valid ticket submitter name, \n" +
                    "expense amount, and expense description. You can submit the ticket.");
        }


        Ticket t = new Ticket(ticket_name, expense_date, expense_description,
                expense_amount, ticket_submitter, expense_Type_fk, ticket_status);

        ticketDao.createNewTicket(t);

        return t;
    }

    public List<Ticket> retrieveAllSubmittedTickets() {

        List<Ticket> allTickets = ticketDao.viewAllSubmittedTickets();
        List<Ticket> allSubmittedTickets = new ArrayList<>();

        for (Ticket t : allTickets) {
            allSubmittedTickets.add(t);
        }

        return allSubmittedTickets;

    }


    public Ticket getByTicketID(int ticket_id) throws TicketDoesNotExistException {
        List<Ticket> allTickets = ticketDao.viewAllSubmittedTickets();

        for (Ticket t : allTickets) {
            if (t.getTicket_Id() == (ticket_id)) {
                return t;
            }


        }
        throw new TicketDoesNotExistException();
    }

    public List<Ticket> viewAllEmployeeSubmittedTickets(String ticket_submitter) {
        List<Ticket> allEmployeeTickets = ticketDao. viewAllEmployeeSubmittedTickets(ticket_submitter);

        for (Ticket t: allEmployeeTickets){
            allEmployeeTickets.add(t);
            return allEmployeeTickets;

        }
        return null;
    }

    public List<Ticket> viewAllSubmittedTickets() {
        List<Ticket> allTickets = ticketDao. viewAllSubmittedTickets();

        for (Ticket t: allTickets){
                allTickets.add(t);
                return allTickets;

        }
        return null;
    }



    public boolean updateTicketStatus(int ticket_id, String ticket_status) throws CannotUpdateException, TicketDoesNotExistException {
        Ticket t = ticketDao.getByTicketID(ticket_id);

        if (t == null) {
            return false;
        }



        if (t.ticket_status.equals("Pending")) {
            t.setTicket_status(ticket_status);
            System.out.println("That is a valid answer.");



        } else if (t.ticket_status.equals("Approved") || t.ticket_status.equals("Denied")){
            throw new CannotUpdateException();

        }

        ticketDao.updateTicketStatus(ticket_status, ticket_id);
        return true;
    }

    public Ticket filterByTicketStatus(String ticket_status) {
        List<Ticket> allTickets = ticketDao.viewAllSubmittedTickets();

        for (Ticket t : allTickets) {
            if (t.getticket_status().equals(ticket_status)) {
                System.out.println(t);
            }


        }
        return null;
    }


    public List<Ticket> viewAllPendingTickets(String ticket_status) {
        List<Ticket> allTickets = ticketDao.viewAllPendingTickets(ticket_status);

        for (Ticket t: allTickets){
            if (t.getticket_status().equals("Pending")){
                allTickets.add(t);
                return allTickets;
            }

        }
        return null;
    }


}






