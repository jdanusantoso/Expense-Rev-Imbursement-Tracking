package com.revature.models;

public class Employee {

    private int employee_id;
    private String employee_first_name;
    private String employee_last_name;
    private String employee_email;
    private String employee_username;
    private String employee_password;
    private String user_level;

    public Employee () {

        //TODO make an all args when we have completed the class

    }

    public Employee(String employee_first_name, String employee_last_name, String employee_email, String employee_username, String employee_password, String user_level) {
        this.employee_first_name = employee_first_name;
        this.employee_last_name = employee_last_name;
        this.employee_email = employee_email;
        this.employee_username = employee_username;
        this.employee_password = employee_password;
        this.user_level = user_level;
    }

    public Employee(int employee_id, String employee_first_name, String employee_last_name, String employee_email, String employee_username, String employee_password, String user_level) {
        this.employee_id = employee_id;
        this.employee_first_name = employee_first_name;
        this.employee_last_name = employee_last_name;
        this.employee_email = employee_email;
        this.employee_username = employee_username;
        this.employee_password = employee_password;
        this.user_level = user_level;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_first_name() {
        return employee_first_name;
    }

    public void setEmployee_first_name(String employee_first_name) {
        this.employee_first_name = employee_first_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }

    public String getEmployee_password() {
        return employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_first_name='" + employee_first_name + '\'' +
                ", employee_last_name='" + employee_last_name + '\'' +
                ", employee_email='" + employee_email + '\'' +
                ", employee_username='" + employee_username + '\'' +
                ", employee_password='" + employee_password + '\'' +
                ", user_level='" + user_level + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return employee_username.equals(employee.employee_username);
    }


}


