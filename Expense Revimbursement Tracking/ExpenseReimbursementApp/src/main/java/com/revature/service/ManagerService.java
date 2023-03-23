package com.revature.service;



import com.revature.dao.ManagerDao;
import com.revature.exception.ManagerDoesNotExistException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Manager;

import java.sql.SQLException;
import java.util.List;


public class ManagerService {

    private ManagerDao managerDao;
    private TicketService ticketService;

    public ManagerService(ManagerDao managerDao, TicketService ticketService) {
        this.managerDao = managerDao;
    }

    public Manager verifyManagerUsernames(String username) throws UsernameAlreadyExistsException {

        List<Manager> manager = managerDao.verifyManagerUsernames(username);

        for (Manager m : manager) {
            if (!m.getUsername().equals(username)) {
                System.out.println("You can use this username.");

            }
        }

        //You may want to instead throw an exception
        throw new UsernameAlreadyExistsException();
    }

    public Manager createNewManager(String employee_first_Name, String employee_last_Name, String email, String username,
                                    String password, String user_Level, int employee_Id_FK) throws SQLException, UsernameAlreadyExistsException {

        List<Manager> manager = managerDao.verifyManagerUsernames(username);

        System.out.println(manager);


        for (Manager m : manager) {
            if (!m.getUsername().equals(username)) {
                m = new Manager(0, employee_first_Name, employee_last_Name, email, username, password, user_Level, employee_Id_FK);
                managerDao.createNewManager(m);
                return m;
            } else if (m.getUsername().equals(username)) {
                return null;

            }
        }
        System.out.println(manager);
        throw new UsernameAlreadyExistsException();

    }

        public Manager loginByUsernamePassword(String username, String password) throws ManagerDoesNotExistException {
            List<Manager> manager = managerDao.getAllManagers();

            for (Manager m : manager) {
                if (m.getUsername().equals(username) && m.getPassword().equals(password)) {
                    return m;
                }
            }

            //You may want to instead throw an exception
            throw new ManagerDoesNotExistException();
        }
    }


