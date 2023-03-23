package com.revature.dao;

import com.revature.exception.EmployeeDoesNotExistException;
import com.revature.models.Employee;
import com.revature.util.JDBCConnectionUTIL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJDBC implements EmployeeDao {

        JDBCConnectionUTIL conUtil = JDBCConnectionUTIL.getInstance();

    @Override
    public Employee createNewEmployee(Employee e){
        try {

            Connection connection = conUtil.getConnectionThroughENV();

            String sql =

                    "INSERT INTO employee (employee_first_name, employee_last_name, employee_email, " +
                            "employee_username, employee_password, user_level) "


                            + "VALUES (?,?,?,?,?,?)";

            PreparedStatement prepared = connection.prepareStatement(sql);

            prepared.setString(1, e.getEmployee_first_name());
            prepared.setString(2, e.getEmployee_last_name());
            prepared.setString(3, e.getEmployee_email());
            prepared.setString(4, e.getEmployee_username());
            prepared.setString(5, e.getEmployee_password() );
            prepared.setString(6, e.getUser_level());


            prepared.executeUpdate();

            return e;

        } catch(SQLException create_emp) {
            create_emp.printStackTrace();
        }

        return null;


    }

    @Override
    public Employee getByEmployeeId(int employee_id) throws EmployeeDoesNotExistException {

        Employee employee = null;

        try {

            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM employee WHERE employee_id = ?";
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, employee_id);

            ResultSet results = prepared.executeQuery();

            while (results.next()) {
                employee = new Employee();
                employee.setEmployee_id(results.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;


    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        List<Employee> employee = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM employee";

            PreparedStatement prepared = connection.prepareStatement(sql);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                employee.add(new Employee(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6), results.getString(7)));
                }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }

        return (ArrayList<Employee>) employee;
    }

    @Override
    public List<Employee> verifyEmployeeUsernames(String employee_username) {
        List<Employee> employee = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM employee WHERE employee_username =?";

            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, employee_username);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {

                employee.add(new Employee(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6), results.getString(7)));
            }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return employee;

    }

    public Employee employeeLoginByUsernamePassword(String employee_username, String employee_password) throws EmployeeDoesNotExistException {

        Employee employee = null;

        try {

            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM employee WHERE employee_username =? and employee_password = ?";
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, employee_username);
            prepared.setString(2, employee_password);

            ResultSet results = prepared.executeQuery();

            while(results.next()) {
                employee = new Employee();
                employee.setEmployee_username(results.getString(5));
                employee.setEmployee_password(results.getString(6));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return employee;


    }

    @Override
    public boolean updateEmployeeLastName(String employee_last_name, int employee_id) {

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "UPDATE employee SET employee_last_name = ? WHERE employee_ID =?";

            PreparedStatement prepared = connection.prepareStatement(sql);

            prepared.setString(1,employee_last_name);
            prepared.setInt(2, employee_id);

            prepared.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean updateEmployeeEmail(String employee_email, int employee_id) {

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "UPDATE employee SET employee_email = ? WHERE employee_ID =?";

            PreparedStatement prepared = connection.prepareStatement(sql);

            prepared.setString(1, employee_email);
            prepared.setInt(2, employee_id);

            prepared.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public List<Employee> getEmployeeInformationById(int employee_id) {
        List<Employee> employee = new ArrayList<>();

        try {
            Connection connection = conUtil.getConnectionThroughENV();

            String sql = "SELECT * FROM employee WHERE employee_id =?";

            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, employee_id);

            ResultSet results = prepared.executeQuery();

            while (results.next()) {

                employee.add(new Employee(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
                        results.getString(5), results.getString(6), results.getString(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;

    }



}



