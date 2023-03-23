package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.EmployeeDaoJDBC;
import com.revature.dao.ManagerDaoJDBC;
import com.revature.dao.TicketDaoJDBC;
import com.revature.exception.ManagerDoesNotExistException;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import com.revature.service.TicketService;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {

    private static EmployeeService employeeService = new EmployeeService(new EmployeeDaoJDBC(), new TicketService(new TicketDaoJDBC()));
    private static ManagerService managerService = new ManagerService(new ManagerDaoJDBC(), new TicketService(new TicketDaoJDBC()));

    public static HttpSession ses;

    public Handler employeeLoginHandler = (ctx) -> {

        String body = ctx.body();

        Gson gson = new Gson();

        Employee eLDTO = gson.fromJson(body, Employee.class);

        Employee empLoggedIn = employeeService.employeeLoginByUsernamePassword(eLDTO.getEmployee_username(), eLDTO.getEmployee_password());

        if(empLoggedIn != null){

            ses = ctx.req.getSession();

            ses.setAttribute("employee_id", empLoggedIn.getEmployee_id());
            ses.setAttribute("user_level", empLoggedIn.getUser_level());



            String userJSON = gson.toJson(empLoggedIn);

            ctx.result("You are logged in as an employee.");
            //ctx.result(userJSON);
            ctx.status(202);

        }else{
            ctx.status(401);
        }

    };

    public Handler managerLoginHandler = (ctx) -> {

        String body = ctx.body();

        Gson gson = new Gson();

        Manager mLDTO = gson.fromJson(body, Manager.class);

        Manager mLoggedIn = null;
        try {
            mLoggedIn = managerService.loginByUsernamePassword(mLDTO.getUsername(), mLDTO.getPassword());
        } catch (ManagerDoesNotExistException e) {
            throw new RuntimeException(e);
        }

        if(mLoggedIn != null){

            ses = ctx.req.getSession();

            ses.setAttribute("mUser_level", mLoggedIn.getmUser_level());

            String userJSON = gson.toJson(mLoggedIn);

            //ctx.result(userJSON);
            ctx.result("You are logged in as a manager.");
            ctx.status(202);

        }else{
            ctx.status(401);
        }

    };



    };

