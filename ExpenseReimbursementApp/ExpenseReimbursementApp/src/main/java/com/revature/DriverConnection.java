package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.TicketController;
import com.revature.exception.*;
import com.revature.util.JDBCConnectionUTIL;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class DriverConnection {

    public static void main(String[] args) {

        try(Connection conn = JDBCConnectionUTIL.getConnectionThroughENV()){
            System.out.println("Connection Successful");
        }
        catch(SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        Javalin app = Javalin.create(

                //This config lambda lets us specify certain configurations for our Javalin object
                // ->? "For this config object, do the following things"
                config -> {
                    config.enableCorsForAllOrigins(); //This lets us process HTTP Requests from anywhere
                }

        ).start(5000); //we need .start() to start our Java server on port 3000
        //You can do any port, I chose 3000 because probably nothing is using it.
        //a port is like a parking space for an application, where messages etc. can find it

        /*----EndPoint Handlers Below----*/

        //Instantiate Controllers

        AuthController ac = new AuthController();

        app.post("/employeeLogin", ac.employeeLoginHandler);

        app.post("/managerLogin", ac.managerLoginHandler);

        app.exception(UsernameAlreadyExistsException.class, (e, managerLoginHandler) -> {
            managerLoginHandler.status(406);
            managerLoginHandler.result("The manager that is trying to login does not have a username or password.");
        });

        app.exception(RuntimeException.class, (e, managerLoginHandler) -> {
            managerLoginHandler.status(406);
            managerLoginHandler.result("The manager that is trying to login does not have a username or password.");
        });

        EmployeeController ec = new EmployeeController();

        app.get("/verifyEmployeeUsernames", ec.verifyEmployeeUsernamesHandler);

        app.exception(UsernameAlreadyExistsException.class, (e, verifyEmployeeUsernameHandler) -> {
            verifyEmployeeUsernameHandler.status(406);
            verifyEmployeeUsernameHandler.result("You are trying to input a username that already exists. Please choose another.");
        });

        app.post("/createNewEmployee", ec.createNewEmployee);

        app.exception(UsernameAlreadyExistsException.class, (e, createNewEmployee) -> {
            createNewEmployee.status(406);
            createNewEmployee.result("you are trying to input a username that already exists. Please choose another.");
        });

        app.get("/getAllEmployee", ec.getAllEmployeesHandler);

        app.patch("/updateEmployeeLastName/{id}", ec.updateEmployeeLastNameHandler);


        app.exception(UnauthorizedBlankResponseException.class, (e, updateEmployeeLastNameHandler) -> {
            updateEmployeeLastNameHandler.status(406);
            updateEmployeeLastNameHandler.result("You are trying to input a response that is outside the parameters.");
        });

        app.patch("/updateEmployeeEmail/{id}", ec.updateEmployeeEmailHandler);


        app.exception(UnauthorizedBlankResponseException.class, (e, updateEmployeeEmailHandler) -> {
            updateEmployeeEmailHandler.status(406);
            updateEmployeeEmailHandler.result("You are trying to input a response that is outside the parameters.");
        });

        app.get("/viewAllEmployeeInformationHandler", ec.viewAllEmployeeInformationHandler);


        app.exception(EmployeeDoesNotExistException.class, (e, viewAllEmployeeInformationHandler) -> {
            viewAllEmployeeInformationHandler.status(406);
            viewAllEmployeeInformationHandler.result("You do not have a valid employee id");
        });

        ManagerController mc = new ManagerController();

        app.post("/createNewManager", mc.createNewManager);

        app.exception(ManagerDoesNotExistException.class, (e, createNewManager) -> {
            createNewManager.status(406);
            createNewManager.result("The manager that is trying to login does not have an existing username and password.");
        });

        app.get("/viewAllManagersHandler", mc.viewAllManagersHandler);

        TicketController tc = new TicketController();

        app.post("/createNewTicket", tc.createNewTicket);

        app.exception(MissingRequiredTicketInformationException.class, (e, createNewTicket) -> {
            createNewTicket.status(406);
            createNewTicket.result("You are submitting a ticket that does not have the required ticket submitter name, expense description, and/or expense amount.");
        });

        app.get("/viewAllEmployeeSubmittedTickets", tc.viewAllEmployeeSubmittedTicketsHandler);

        app.get("/viewAllSubmittedTickets", tc.viewAllSubmittedTicketsHandler);

        app.patch("/updateTicketStatus/{id}", tc.updateTicketStatusHandler);


        app.exception(CannotUpdateException.class, (e, updateTicketStatusHandler) -> {
            updateTicketStatusHandler.status(406);
            updateTicketStatusHandler.result("You are trying to update an unchangeable field.");
        });

        app.get("/viewAllPendingTickets", tc.viewAllPendingTicketsHandler);

    }



}
