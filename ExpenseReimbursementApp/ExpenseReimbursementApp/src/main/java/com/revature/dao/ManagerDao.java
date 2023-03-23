package com.revature.dao;

import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Manager;

import java.sql.SQLException;
import java.util.List;

public interface ManagerDao {
    List<Manager> verifyManagerUsernames(String managerUsername) throws UsernameAlreadyExistsException;
    Manager createNewManager(Manager m) throws SQLException;

    List<Manager> getAllManagers();

    Manager loginByUsernamePassword (String username, String Password) ;




}

