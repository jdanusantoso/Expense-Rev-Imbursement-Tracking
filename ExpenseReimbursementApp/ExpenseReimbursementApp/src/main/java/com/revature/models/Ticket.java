package com.revature.models;

public class Ticket {

    private int ticket_Id;
    private String ticket_name;
    private int expense_date;
    private String expense_description;
    private Double expense_amount;
    private String ticket_submitter;
    public String ticket_status;
    private int expense_type_fk;


    public Ticket() {
        System.out.println("The no args constructor.");

    }

    public Ticket(String ticket_name, int expense_date, String expense_description, double expense_amount, String ticket_submitter, int expense_type_fk, String ticket_status ) {

        super();
        this.ticket_name = ticket_name;
        this.expense_date = expense_date;
        this.expense_description = expense_description;
        this.expense_amount = expense_amount;
        this.ticket_submitter = ticket_submitter;
        this.expense_type_fk = expense_type_fk;
        this.ticket_status = ticket_status;

    }

    public Ticket(int ticket_Id, String ticket_name, int expense_date, String expense_description, Double expense_amount, String ticket_submitter, String ticket_status, int expense_type_fk) {
        this.ticket_Id = ticket_Id;
        this.ticket_name = ticket_name;
        this.expense_date = expense_date;
        this.expense_description = expense_description;
        this.expense_amount = expense_amount;
        this.ticket_submitter = ticket_submitter;
        this.ticket_status = ticket_status;
        this.expense_type_fk = expense_type_fk;

    }

    public Ticket(String ticket_name, int expense_date, String expense_description, double expense_amount, String ticket_submitter, int expense_type_fk, String ticket_status, int ticket_id ) {

        super();
        this.ticket_name = ticket_name;
        this.expense_date = expense_date;
        this.expense_description = expense_description;
        this.expense_amount = expense_amount;
        this.ticket_submitter = ticket_submitter;
        this.expense_type_fk = expense_type_fk;
        this.ticket_status = ticket_status;
        this.ticket_Id = ticket_id;


    }

    public Ticket(String ticket_status) {
        super();
        this.ticket_status = ticket_status;
    }


    public int getTicket_Id() {
        return ticket_Id;
    }

    public void setTicket_Id(int ticket_Id) {
        this.ticket_Id = ticket_Id;
    }

    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) {
        this.ticket_name = ticket_name;
    }


    public int getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(int expense_date) {
        this.expense_date = expense_date;
    }

    public String getexpense_description() {
        return expense_description;
    }

    public void setexpense_description(String expense_description) {
        this.expense_description = expense_description;
    }

    public double getExpense_amount() {
        return expense_amount;
    }

    public void setExpense_amount(Double expense_amount) {
        this.expense_amount = expense_amount;
    }

    public String getticket_submitter() {
        return ticket_submitter;
    }

    public void setticket_submitter(String ticket_submitter) {
        this.ticket_submitter = ticket_submitter;
    }


    public String getticket_status() {
        return ticket_status;
    }

    public void setTicket_status(String ticket_status) {
        this.ticket_status = ticket_status;
    }


    public int getexpense_type_fk() {
        return expense_type_fk;
    }

    public void setexpenseType(int expense_type_fk) {
        this.expense_type_fk = expense_type_fk;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_Id=" + ticket_Id +
                ", ticket_name='" + ticket_name + '\'' +
                ", expense_date=" + expense_date +
                ", expense_description='" + expense_description + '\'' +
                ", expense_amount=" + expense_amount +
                ", ticket_submitter='" + ticket_submitter + '\'' +
                ", ticket_status='" + ticket_status + '\'' +
                ", expense_type_fk=" + expense_type_fk +
                '}';
    }

}


