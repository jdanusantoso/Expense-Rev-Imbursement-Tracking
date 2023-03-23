package com.revature.dao;

import com.revature.models.Manager;
import com.revature.util.JDBCConnectionUTIL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoJDBC implements ManagerDao  {

    JDBCConnectionUTIL conUtil = JDBCConnectionUTIL.getInstance();

    @Override
    public List<Manager> verifyManagerUsernames(String username) {
        List<Manager> manager = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM manager WHERE username =?";

            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, username);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                manager.add(new Manager(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6), results.getString(7), results.getInt(8)));
            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return manager;

    }

    @Override
    public Manager createNewManager(Manager m) throws SQLException {
        try {

            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "INSERT INTO manager(employee_first_name, employee_last_name, "
                    + "email, username, password, user_level, employee_id_fk) "
                    + "values (?,?,?,?,?,?,?)";

            PreparedStatement prepared = connection.prepareStatement(sql);

            prepared.setString(1, m.getEmployee_firstName());
            prepared.setString(2, m.getEmployee_last_Name());
            prepared.setString(3, m.getEmail());
            prepared.setString(4, m.getUsername());
            prepared.setString(5, m.getPassword());
            prepared.setString(6, m.getmUser_level());
            prepared.setInt(7, m.getEmployee_Id_FK());

            prepared.execute();

            return m;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> manager = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM manager";

            PreparedStatement prepared = connection.prepareStatement(sql);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                manager.add(new Manager(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6), results.getString(7)));
            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return manager;

    }

    @Override
    public Manager loginByUsernamePassword(String username, String password) {

        Manager manager = null;

        try {

            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM manager WHERE username =? and password = ?";
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, username);
            prepared.setString(2, password);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {
                manager = new Manager();

//                manager.setManager_Id(results.getInt(1));
//                manager.setEmployee_firstName(results.getString(2));
//                manager.setEmployee_last_Name(results.getString(3));
//                manager.setEmail(results.getString(4));
                manager.setUsername(results.getString(5));
                manager.setPassword(results.getString(6));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return manager;
    }




}


