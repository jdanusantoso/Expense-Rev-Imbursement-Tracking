package com.revature.dao;

import com.revature.exception.EmployeeDoesNotExistException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.models.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {
    List<Employee> verifyEmployeeUsernames(String employeeUsername) throws UsernameAlreadyExistsException;
    Employee createNewEmployee(Employee e);

    ArrayList<Employee> getAllEmployees();

    Employee employeeLoginByUsernamePassword(String employee_username, String employee_password) throws EmployeeDoesNotExistException;

    Employee getByEmployeeId(int employee_id) throws EmployeeDoesNotExistException;

    boolean updateEmployeeLastName(String employee_last_name, int employee_id);

    boolean updateEmployeeEmail(String employee_email, int employee_id);

    List<Employee> getEmployeeInformationById (int employee_id);


}