package com.revature.finalproject;

import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoJDBC;
import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoJDBC;
import com.revature.exception.CannotUpdateException;
import com.revature.exception.ManagerDoesNotExistException;
import com.revature.exception.TicketDoesNotExistException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Manager;
import com.revature.models.Ticket;
import com.revature.service.ManagerService;
import com.revature.service.TicketService;
import com.revature.util.JDBCConnectionUTIL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JDBCManagerDriver {

    private static ManagerDao managerDao= new ManagerDaoJDBC();
    private static TicketDao ticketDao = new TicketDaoJDBC();
    private static TicketService ticketService = new TicketService(ticketDao);
    private static ManagerService managerService = new ManagerService(managerDao, new TicketService(new TicketDaoJDBC()));



    public static void main(String[] args) throws TicketDoesNotExistException, CannotUpdateException, ManagerDoesNotExistException, SQLException, UsernameAlreadyExistsException {

        JDBCConnectionUTIL conUtil = JDBCConnectionUTIL.getInstance();

        //conUtil.getConnectionThroughPropFile();

        Connection con = conUtil.getConnectionThroughENV();


//	Scanner input = new Scanner(System.in);

        boolean notDone = true;

        Manager loggedIn = null;

        Scanner in = new Scanner(System.in);


        while(notDone) {

            System.out.println("What would you like to do?");
            System.out.println("Press 1: to register. \n" +
                    "Press 2: To login into your account. \n"
                    + "Press 3: To view all submitted expense reimbursement tickets. \n"
                    + "Press 4: To search by ticket submitter. \n"
                    + "Press 5: To update ticket status.\n"
                    + "Press 6: To view all pending tickets.\n");


            int choice = in.nextInt();
            in.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Enter your first name: ");
                    String employee_first_name = in.nextLine();
                    System.out.print("Enter your last name: ");
                    String employee_last_name = in.nextLine();
                    System.out.print("Enter your email: ");
                    String email = in.nextLine();
                    System.out.print("Enter your username: ");
                    String username = in.nextLine();
                    System.out.print("Enter your password: ");
                    String password = in.nextLine();
                    System.out.print("Enter your user level. Type in manager or employee: ");
                    String user_Level = in.nextLine();
                    System.out.print("Enter your employee id: ");
                    int employee_Id_FK = in.nextInt();

                    managerService.createNewManager(employee_first_name, employee_last_name, email, username,
                            password, user_Level, employee_Id_FK);
                    break;

                case 2:
                    System.out.print("Please type in your username: ");
                    username = in.nextLine();
                    System.out.print("Please type in your password: ");
                    password = in.nextLine();
                    loggedIn = managerService.loginByUsernamePassword(username, password);
                    System.out.println("Welcome in: " + loggedIn.getUsername());

                    break;

                case 3:
                    List<Ticket> tickets = ticketService.retrieveAllSubmittedTickets();
                    break;

                case 4:
                    System.out.print("Enter the ticket id you are looking for: ");
                    int ticket_id = in.nextInt();
                    System.out.println(ticketService.getByTicketID(ticket_id));
                    break;


                case 5:


                    System.out.print("Please enter the ticket id you want to approve or deny.");
                    ticket_id = in.nextInt();
//                    System.out.println("What is the current ticket status?");
//                    String OldTicket_Status = in.nextLine() + in.next();
                    System.out.println("Enter Approved or Denied");
                    String ticket_status = in.nextLine() + in.next();
                    ticketService.updateTicketStatus(ticket_id, ticket_status);
                    break;

                case 6:

                    System.out.println("Type 'Pending' to view all pending tickets");
                    ticket_status = in.nextLine();
                    ticketService.filterByTicketStatus(ticket_status);
                    break;

                default:
                    System.out.println("You do not have a valid response. Please type in a number.");
            }

        System.out.println("Are you done? Y/N");
        String finished = in.next()+ in.nextLine();
        if(finished.equals("Y")) {
            notDone = false;
        }

    }
    }

}