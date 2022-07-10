package com.bus.reservation.app;

public class QueriesConstants {

    public static final String DROP_RESERVATION = "DROP TABLE reservation";

    public static final String DROP_BUS = "DROP TABLE bus";

    public static final String DROP_PASSENGER = "DROP TABLE passenger";

    public static final String DROP_ROUTE = "DROP TABLE route";

    public static final String DROP_BUS_STATUS = "DROP TABLE BUS_STATUS";

    public static final String CREATE_RESERVATION_TABLE = "CREATE TABLE Reservation ( \n" +
            "reservation_id INT NOT NULL AUTO_INCREMENT, \n" +
            "cost INT, \n" +
            "status VARCHAR(20),\n" +
            "reservation_date DATE, \n" +
            "departure_date DATE, \n" +
            "CONSTRAINT reservation_pk \n" +
            "PRIMARY KEY (reservation_id))";

    public static final String CREATE_BUS_TABLE = "CREATE TABLE Bus ( \n" +
            "bus_id INT NOT NULL AUTO_INCREMENT, \n" +
            "name VARCHAR(10), \n" +
            "source VARCHAR(20),\n" +
            "destination VARCHAR(20), \n" +
            "CONSTRAINT bus_pk \n" +
            "PRIMARY KEY (bus_id))";

    public static final String CREATE_PASSENGER_TABLE = "CREATE TABLE Passenger ( \n" +
            "passenger_id INT NOT NULL AUTO_INCREMENT, \n" +
            "bus_id INT NOT NULL,\n" +
            "reservation_id INT NOT NULL, \n" +
            "name VARCHAR(20),\n" +
            "email VARCHAR(20),\n" +
            "age INT,\n" +
            "gender VARCHAR(1) CHECK (GENDER IN ('M','F')),\n" +
            "CONSTRAINT passenger_pk PRIMARY KEY (passenger_id), \n" +
            "CONSTRAINT passenger_bus_fk FOREIGN KEY (bus_id) REFERENCES bus(bus_id), \n" +
            "CONSTRAINT reservation_fk FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id))";

    public static final String CREATE_ROUTE_TABLE = "CREATE TABLE Route ( \n" +
            "route_id INT NOT NULL AUTO_INCREMENT, \n" +
            "bus_id INT NOT NULL,\n" +
            "arrival_time VARCHAR(10),\n" +
            "route_marker VARCHAR(10), \n" +
            "CONSTRAINT route_pk \n" +
            "PRIMARY KEY (route_id), \n" +
            "CONSTRAINT route_bus_fk FOREIGN KEY (bus_id) REFERENCES bus(bus_id))";


    public static final String CREATE_BUS_STATUS_TABLE = "CREATE TABLE Bus_Status(\n" +
            "bus_status_id INT NOT NULL AUTO_INCREMENT, \n" +
            "bus_id INT,\n" +
            "bus_date DATE, \n" +
            "booked_seats INT, \n" +
            "available_seats INT NOT NULL, \n" +
            "wait_listed_seats INT, \n" +
            "PRIMARY KEY (bus_status_id),\n" +
            "CONSTRAINT bus_status_fk FOREIGN KEY (bus_id) REFERENCES bus(bus_id))";
}
