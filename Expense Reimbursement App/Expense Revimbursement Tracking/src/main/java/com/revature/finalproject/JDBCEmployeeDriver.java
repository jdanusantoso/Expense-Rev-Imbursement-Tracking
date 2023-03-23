package com.revature.finalproject;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoJDBC;
import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoJDBC;
import com.revature.exception.EmployeeDoesNotExistException;
import com.revature.exception.MissingRequiredTicketInformationException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.TicketService;
import com.revature.util.JDBCConnectionUTIL;

import java.sql.SQLException;
import java.util.Scanner;

public class JDBCEmployeeDriver {

    private static EmployeeDao employeeDao= new EmployeeDaoJDBC();
    private static TicketDao ticketDao = new TicketDaoJDBC();
    private static TicketService ticketService = new TicketService(ticketDao);
    private static EmployeeService employeeService = new EmployeeService(employeeDao);



    public static void main(String[] args) throws MissingRequiredTicketInformationException, EmployeeDoesNotExistException, UsernameAlreadyExistsException, SQLException {

        JDBCConnectionUTIL conUtil = JDBCConnectionUTIL.getInstance();

        //conUtil.getConnectionThroughPropFile();

        conUtil.getConnectionThroughENV();

        Scanner input = new Scanner(System.in);

        boolean notDone = true;
        Employee empLoggedIn = null;

        while(notDone) {

            System.out.println("What would you like to do?"
                    + "Press: 1 to register, Press 2: To login into your account; \n"
                    + "Press 3: To complete and submit expense reimbursement tickets; \n"
                    + "Press 4: To view all your expense reimbursement tickets; \n"
                    + "Press 5: To view all your expense reimbursement tickets by status;");

            int emp_Choice = input.nextInt();
            input.nextLine();

            switch(emp_Choice) {


                case 1: System.out.print("Enter your first name: ");
                    String employee_first_name = input.nextLine();
                    System.out.print("Enter your last name: ");
                    String employee_last_name = input.nextLine();
                    System.out.print("Enter your email: ");
                    String employee_email = input.nextLine();
                    System.out.print("Enter your username: ");
                    String employee_username = input.nextLine();
                    System.out.print("Enter your password: ");
                    String employee_password = input.nextLine();
                    System.out.print("Enter your user level. Type in manager or employee: ");
                    String userLevel = input.nextLine();

                    employeeService.createNewEmployee(employee_first_name, employee_last_name, employee_email,
                            employee_username, employee_password, userLevel);
                    break;

//                case 2:
//                    System.out.print("Please type in your username: ");
//                    employee_username = input.nextLine();
//
//
//                    empLoggedIn = employeeService.employeeLoginByUsername(employee_username);
//                    if(empLoggedIn != null) {
//                        System.out.println("Welcome in: " + empLoggedIn.getEmployee_first_name());
//                    }
//
//                    else {
//                        //System.out.println("The username does not exists.");
//                        throw new EmployeeDoesNotExistException();
//
//                    }
//
//                    break;

                case 2:
                    System.out.print("Please type in your username: ");
                    employee_username = input.nextLine();
                    System.out.print("Please type in your password: ");
                    employee_password = input.nextLine();

                        empLoggedIn = employeeService.employeeLoginByUsernamePassword(employee_username, employee_password);
                        if(empLoggedIn != null) {
                            System.out.println("Welcome in: " + empLoggedIn.getEmployee_first_name());
                        }

                        else {
                            //System.out.println("The username does not exists.");
                            throw new EmployeeDoesNotExistException();

                        }

                    break;

                case 3:
                    System.out.print("Please follow the instructions on the next screen. Press enter to submit."
                            + "Enter the expense ticket name: ");
                    String ticket_name = input.nextLine();

                    System.out.println("Enter the expense date in MMddYYYY format: ");
                    int expense_date = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter the expense description: ");
                    String expense_description = input.nextLine();


                    System.out.println("Enter the expense amount: ");
                    Double expense_amount = input.nextDouble();
                    input.nextLine();

                    System.out.println("Enter your name: ");
                    String ticket_submitter = input.nextLine();

                    System.out.print("Enter the expense type number (Food (1), Lodging (2), Travel (3), Professional_Development (4), Other (5) "
                    );
                    int expense_Type_fk = input.nextInt();
                    input.nextLine();

                    String ticket_statusD = "Pending";
                    String ticket_status = ticket_statusD;

                    System.out.println(ticket_status);

                    ticketService.createNewTicket(ticket_name, expense_date, expense_description,
                            expense_amount, ticket_submitter, expense_Type_fk, ticket_status);

                    input.nextLine();
                    break;


//                case 4:
//
//
//                    System.out.print("Enter your name to see all the tickets you have submitted: ");
//                    ticket_submitter = input.nextLine();
//
//                    List<Ticket> tickets = ticketService.viewAllEmployeeSubmittedTickets(ticket_submitter);
//
//
//                    for(Ticket t: tickets) {
//                        System.out.println(ticketService.getByTicketSubmitter(ticket_submitter));
//
//                    }
//                    break;

/*
                case 5:
                    tickets = ticketService.viewAllTickets();

                    System.out.print("Enter your name to see all the tickets you have submitted: ");
                    ticket_submitter = input.nextLine();
                    System.out.print("Enter Pending, Approve, or Deny to filter by ticket status: ");
                    ticket_status = input.nextLine();

                    if(!ticket_submitter.isEmpty()){
                        if(ticket_status.equals("Approved") || ticket_status.equals("Denied") || ticket_status.equals("null")){
                            for(Ticket t : tickets ) {
                                System.out.println(t);
                            }
                        }
                    }

                    System.out.println(ticketService.filterTicketsByStatus(ticket_submitter, ticket_status));
                    break;
*/
                default:
                    System.out.println("You do not have a valid response. Please type in a number.");

            }
            System.out.println("Are you done? Y/N");
            String finished = input.nextLine();
            if(finished.equals("Y")) {
                notDone = false;
            }


        }

        input.close();



    }


}

