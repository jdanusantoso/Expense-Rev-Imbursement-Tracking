package com.revature.dao;

import com.revature.exception.CannotUpdateException;
import com.revature.models.Ticket;
import com.revature.models.TicketType;
import com.revature.util.JDBCConnectionUTIL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoJDBC implements TicketDao {

    JDBCConnectionUTIL conUtil = JDBCConnectionUTIL.getInstance();



    @Override
    public Ticket createNewTicket(Ticket t) {

        try {

            Connection connection = conUtil.getConnectionThroughENV();

            String sql =




                    "INSERT INTO tickets (ticket_name, expense_date, expense_description, " +
                            "expense_amount, ticket_submitter, expense_type_fk, ticket_status) " +
                            "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement prepared = connection.prepareStatement(sql);

            prepared.setString(1, t.getTicket_name());
            prepared.setInt(2, t.getExpense_date());
            prepared.setString(3, t.getexpense_description());
            prepared.setDouble(4, t.getExpense_amount());
            prepared.setString(5, t.getticket_submitter());
            prepared.setInt(6, t.getexpense_type_fk());
            prepared.setString(7, "Pending");


            prepared.execute();

            return t;

        }catch(SQLException e) { e.printStackTrace(); }

        return null;

    }


    @Override
    public List<Ticket> viewAllSubmittedTickets() {
        List<Ticket> ticket = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM tickets";

            PreparedStatement prepared = connection.prepareStatement(sql);


            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                TicketType expenseType;

                switch(results.getInt(8)) {
                    case 1:
                        expenseType = TicketType.Food;
                        break;
                    case 2:
                        expenseType = TicketType.Lodging;
                        break;
                    case 3:
                        expenseType = TicketType.Travel;
                        break;
                    case 4:
                        expenseType = TicketType.Professional_Development;
                        break;
                    default:
                        expenseType = TicketType.Other;
                        break;
                }



                ticket.add(new Ticket(results.getString(1), results.getInt(2), results.getString(3), results.getDouble(4),
                        results.getString(5), results.getInt(6), results.getString(7) ));
            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return ticket;

    }

    @Override
    public List<Ticket> viewAllEmployeeSubmittedTickets(String ticket_submitter) {
        List<Ticket> ticket = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM tickets where ticket_submitter = ?";

            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, ticket_submitter);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                TicketType expenseType;

                switch(results.getInt(8)) {
                    case 1:
                        expenseType = TicketType.Food;
                        break;
                    case 2:
                        expenseType = TicketType.Lodging;
                        break;
                    case 3:
                        expenseType = TicketType.Travel;
                        break;
                    case 4:
                        expenseType = TicketType.Professional_Development;
                        break;
                    default:
                        expenseType = TicketType.Other;
                        break;
                }



                ticket.add(new Ticket(results.getString(1), results.getInt(2), results.getString(3), results.getDouble(4),
                        results.getString(5), results.getInt(6), results.getString(7) ));
            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return ticket;

    }


    @Override
    public Ticket getByTicketID(int ticket_id) {

        Ticket ticket = null;

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM tickets WHERE ticket_id = ?";

            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, ticket_id);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                TicketType Expensetype;
                switch(results.getInt(8)) {
                    case 1:
                        Expensetype = TicketType.Food;
                        break;
                    case 2:
                        Expensetype = TicketType.Lodging;
                        break;
                    case 3:
                        Expensetype = TicketType.Travel;
                        break;
                    case 4:
                        Expensetype = TicketType.Professional_Development;
                        break;
                    default:
                        Expensetype = TicketType.Other;
                        break;
                }

                ticket = new Ticket(results.getString(1), results.getInt(2), results.getString(3), results.getDouble(4),
                        results.getString(5), results.getInt(6), results.getString(7));


            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return ticket;

    }

    @Override
    public boolean updateTicketStatus (String ticket_status, int ticket_id) throws CannotUpdateException {
        try  {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "UPDATE tickets SET ticket_status = ? WHERE ticket_ID =?";

            PreparedStatement prepared = connection.prepareStatement(sql);

            prepared.setString(1, ticket_status);
            prepared.setInt(2, ticket_id);

            prepared.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public List<Ticket> viewAllPendingTickets(String ticket_status) {
        List<Ticket> ticket = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM tickets where ticket_status = ?";

            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, ticket_status);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                TicketType expenseType;

                switch(results.getInt(8)) {
                    case 1:
                        expenseType = TicketType.Food;
                        break;
                    case 2:
                        expenseType = TicketType.Lodging;
                        break;
                    case 3:
                        expenseType = TicketType.Travel;
                        break;
                    case 4:
                        expenseType = TicketType.Professional_Development;
                        break;
                    default:
                        expenseType = TicketType.Other;
                        break;
                }



                ticket.add(new Ticket(results.getString(1), results.getInt(2), results.getString(3), results.getDouble(4),
                        results.getString(5), results.getInt(6), results.getString(7), results.getInt(8) ));
            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return ticket;

    }


}


