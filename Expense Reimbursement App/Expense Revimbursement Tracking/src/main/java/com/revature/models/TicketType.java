package com.revature.models;

public enum TicketType {

    Food(1), Lodging(2), Travel(3), Professional_Development(4), Other(5);
    int id;
    TicketType(int Id) {id = Id;}

}
