package com.revature.models;

import java.util.List;

public class Manager {

    private int manager_Id;
    private String employee_firstName;
    private String employee_last_Name;
    private String email;
    private String username;
    private String password;
    private String mUser_level;
    private int employee_Id_FK;
    private List<Ticket> viewAllSubmittedTickets;

    public Manager() {

        //TODO create an allargs constructor



    }

    public Manager(int manager_Id, String employee_firstName, String employee_last_Name, String email, String username, String password, String mUser_level) {
        this.manager_Id = manager_Id;
        this.employee_firstName = employee_firstName;
        this.employee_last_Name = employee_last_Name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mUser_level = mUser_level;
    }

    public Manager(int manager_Id, String employee_firstName, String employee_last_Name, String email, String username, String password, String mUser_level, int employee_Id_FK) {
        this.manager_Id = manager_Id;
        this.employee_firstName = employee_firstName;
        this.employee_last_Name = employee_last_Name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mUser_level = mUser_level;
        this.employee_Id_FK = employee_Id_FK;
    }

    public int getManager_Id() {
        return manager_Id;
    }

    public void setManager_Id(int manager_Id) {
        this.manager_Id = manager_Id;
    }

    public String getEmployee_firstName() {
        return employee_firstName;
    }

    public void setEmployee_firstName(String employee_firstName) {
        this.employee_firstName = employee_firstName;
    }

    public String getEmployee_last_Name() {
        return employee_last_Name;
    }

    public void setEmployee_last_Name(String employee_last_Name) {
        this.employee_last_Name = employee_last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getmUser_level() {
        return mUser_level;
    }

    public void setmUser_level(String mUser_level) {
        this.mUser_level = mUser_level;
    }

    public int getEmployee_Id_FK() {
        return employee_Id_FK;
    }

    public void setEmployee_Id_FK(int employee_Id_FK) {
        this.employee_Id_FK = employee_Id_FK;
    }



    public List<Ticket> getViewAllSubmittedTickets() {
        return viewAllSubmittedTickets;
    }

    public void setViewAllSubmittedTickets(List<Ticket> viewAllSubmittedTickets) {
        this.viewAllSubmittedTickets = viewAllSubmittedTickets;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_Id=" + manager_Id +
                ", employee_firstName='" + employee_firstName + '\'' +
                ", employee_last_Name='" + employee_last_Name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mUser_level='" + mUser_level + '\'' +
                ", employee_Id_FK=" + employee_Id_FK +
                ", viewAllSubmittedTickets=" + viewAllSubmittedTickets +
                '}';
    }

}



