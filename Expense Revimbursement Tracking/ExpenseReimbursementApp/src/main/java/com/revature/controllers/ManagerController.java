package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.ManagerDaoJDBC;
import com.revature.dao.TicketDaoJDBC;
import com.revature.models.Manager;
import com.revature.service.ManagerService;
import com.revature.service.TicketService;
import io.javalin.http.Handler;

import java.util.List;

public class ManagerController {

    private static ManagerService managerService = new ManagerService(new ManagerDaoJDBC(), new TicketService(new TicketDaoJDBC()));

    ManagerDaoJDBC mDao = new ManagerDaoJDBC();



    public Handler createNewManager = (ctx) -> {

        if(AuthController.ses != null){

            System.out.println(AuthController.ses.getAttribute("mUser_level"));

            if(AuthController.ses.getAttribute("mUser_level") == null){
                ctx.status(403);
                ctx.result("You must be logged as an manager in order to perform this action.");
                return;
            }

        String body = ctx.body();

        Gson gson = new Gson();

        Manager newM = gson.fromJson(body, Manager.class);

        newM = mDao.createNewManager(newM);

        if(newM != null){
            ctx.status(201);
            ctx.result(body);

        } else{
            ctx.status(406);
            ctx.result("You are trying to input a username that already exists. Please choose another.");
        }
        }else{
            ctx.result("You must be logged in as a manager in order to perform this action.");
            ctx.status(401);
        }
    };

    public Handler viewAllManagersHandler = (ctx) -> {

        if(AuthController.ses != null){

            System.out.println(AuthController.ses.getAttribute("mUser_level"));

            if(AuthController.ses.getAttribute("mUser_level") == null){
                ctx.status(403);
                ctx.result("You must be logged as an manager in order to perform this action.");
                return;
            }

        List<Manager> manager = mDao.getAllManagers();

        Gson gson = new Gson();

        String JSONManagers = gson.toJson(manager);

        ctx.result(JSONManagers);

        ctx.status(202);

        }else{
            ctx.result("You must be logged in as a manager in order to perform this action.");
            ctx.status(401);
        }
    };

}


