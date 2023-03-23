package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.EmployeeDaoJDBC;
import com.revature.dao.TicketDaoJDBC;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.TicketService;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeController {

    private static EmployeeService employeeService = new EmployeeService(new EmployeeDaoJDBC(), new TicketService(new TicketDaoJDBC()));

    EmployeeDaoJDBC eDao = new EmployeeDaoJDBC();

    public Handler verifyEmployeeUsernamesHandler = (ctx) -> {

        String body = ctx.body();

        Gson gson = new Gson();

        Employee newE = gson.fromJson(body, Employee.class);

        newE = employeeService.verifyEmployeeUsernames(newE.getEmployee_username());

        if(newE != null){
            ctx.status(201);
            ctx.result(body);

        }else{
            ctx.status(406);
            ctx.result("Employee username already exists.");



        }



    };

    public Handler createNewEmployee = (ctx) -> {

        String body = ctx.body();

        Gson gson = new Gson();

        Employee newE = gson.fromJson(body, Employee.class);

        newE = eDao.createNewEmployee(newE);

//        System.out.println(newE);
        if(newE != null){
            ctx.status(201);
            ctx.result(body); //Send back the employee
        }

        else{
            ctx.status(406);
            ctx.result("You are trying to input a username that already exists. Please choose another.");
        }

    };

    public Handler updateEmployeeLastNameHandler = (ctx) -> {

        if(AuthController.ses != null){

            System.out.println(AuthController.ses.getAttribute("user_level"));
            System.out.println(AuthController.ses.getAttribute("employee_id"));

            if(AuthController.ses.getAttribute("user_level") == null){
                ctx.status(403);
                ctx.result("You must be logged as an employee in order to perform this action.");
                return;
            }

            if(AuthController.ses.getAttribute("employee_id") == null){
                ctx.status(403);
                ctx.result("You are not authorized to perform this action.");
                return;
            }

            int employee_id = Integer.parseInt(ctx.pathParam("id"));
            System.out.println(employee_id);

            String employee_last_name = ctx.body();

            if (employeeService.updateEmployeeLastName(employee_last_name, employee_id)) {
                ctx.status(202);
                ctx.result("Employee information update success.");

            } else {
                ctx.status(406);
                ctx.result("Employee information update failed.");

            }
        }else{
            ctx.result("You must be logged in order to perform this action.");
            ctx.status(401);
        }

    };

    public Handler updateEmployeeEmailHandler = (ctx) -> {

        if(AuthController.ses != null){

            System.out.println(AuthController.ses.getAttribute("user_level"));
            System.out.println(AuthController.ses.getAttribute("employee_id"));

            if(AuthController.ses.getAttribute("user_level") == null){
                ctx.status(403);
                ctx.result("You must be logged as an employee in order to perform this action.");
                return;
            }

            if(AuthController.ses.getAttribute("employee_id") == null){
                ctx.status(403);
                ctx.result("You are not authorized to perform this action.");
                return;
            }

            int employee_id = Integer.parseInt(ctx.pathParam("id"));
            System.out.println(employee_id);

            String employee_email = ctx.body();


            if (employeeService.updateEmployeeEmail(employee_email, employee_id)) {
                ctx.status(202);
                ctx.result("Employee information update success.");

            } else {
                ctx.status(406);
                ctx.result("Employee information update failed.");

            }
        }else{
            ctx.result("You must be logged in order to perform this action.");
            ctx.status(401);
        }

    };

    public Handler viewAllEmployeeInformationHandler = (ctx) -> {

        if(AuthController.ses != null){

            System.out.println(AuthController.ses.getAttribute("user_level"));
            System.out.println(AuthController.ses.getAttribute("employee_id"));

            int employeeId = (Integer)AuthController.ses.getAttribute("employee_id");

            if(AuthController.ses.getAttribute("user_level") == null){
                ctx.status(403);
                ctx.result("You must be logged as an manager in order to perform this action.");
                return;
            }

            if(!AuthController.ses.getAttribute("employee_id").equals(employeeId)){
                ctx.status(403);
                ctx.result("You do not have access to perform this action as an employee.");
                return;
            }

        List<Employee> employee = eDao.getEmployeeInformationById(202);

        Gson gson = new Gson();

        String JSONEmployees = gson.toJson(employee);

        ctx.result(JSONEmployees);

        ctx.status(202);

       }else{
            ctx.result("You must be logged in as a manager in order to perform this action.");
            ctx.status(401);
        }
    };

    public Handler getAllEmployeesHandler = (ctx) -> {

        List<Employee> allEmployees = eDao.getAllEmployees();

        Gson gson = new Gson();

        String JSONEmployees = gson.toJson(allEmployees);

        ctx.status(202);

        ctx.result(JSONEmployees);

    };


}
