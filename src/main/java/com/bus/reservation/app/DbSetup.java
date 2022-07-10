package com.bus.reservation.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSetup {

    public Connection connection;

    public DbSetup(){
        this.connection = DbConnection.getInstance().getDbConnection();
    }

    /**
     * Creating the tables
     * */
    public void setUpTables() {

        try {

            Statement stmt = connection.createStatement();
            // Drop Existing Tables If exists
            stmt.execute(QueriesConstants.DROP_PASSENGER);
            stmt.execute(QueriesConstants.DROP_BUS_STATUS);
            stmt.execute(QueriesConstants.DROP_ROUTE);
            stmt.execute(QueriesConstants.DROP_RESERVATION);
            stmt.execute(QueriesConstants.DROP_BUS);

            stmt.execute(QueriesConstants.CREATE_BUS_TABLE);
            stmt.execute(QueriesConstants.CREATE_BUS_STATUS_TABLE);
            stmt.execute(QueriesConstants.CREATE_ROUTE_TABLE);
            stmt.execute(QueriesConstants.CREATE_RESERVATION_TABLE);
            stmt.execute(QueriesConstants.CREATE_PASSENGER_TABLE);
            stmt.close();

        }catch (Exception e) {
            e.printStackTrace();
            //System.exit(1);
        }
    }

    /**
     * Inserting data into the tables */
    public void insertData() {
        try {
            Statement stmt = connection.createStatement();
            //Insert into BUS table
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1001,'Bus1','Santa Clara','San Jose')");
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1002,'Bus2','Santa Clara','San Francisco')");
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1003,'Bus3','San Jose','Santa Clara')");
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1004,'Bus4','San Francisco','San Jose')");
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1005,'Bus5','San Jose','Santa Cruz')");
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1006,'Bus6','San Jose','Mountain View')");
            stmt.executeUpdate("INSERT INTO Bus (bus_id,name,source,destination) VALUES (1007,'Bus7','San Francisco','Berkeley')");

            //Insert into BUS_STATUS table
            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1001,TIMESTAMP'2021-10-16 00:00:00.0',100,0,10)");

            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1002,TIMESTAMP'2021-10-16 00:00:00.0',27,13,0)");

            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1003,TIMESTAMP'2021-10-15 00:00:00.0',35,5,0)");

            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1004,TIMESTAMP'2021-10-14 00:00:00.0',40,0,29)");

            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1005,TIMESTAMP'2021-10-17 00:00:00.0',40,0,0)");

            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1006,TIMESTAMP'2021-10-15 00:00:00.0',19,21,0)");

            stmt.executeUpdate("INSERT INTO Bus_Status (bus_id,bus_date,booked_seats,available_seats,wait_listed_seats) \n" +
                    "VALUES (1007,TIMESTAMP'2021-10-18 00:00:00.0',39,1,0)");

            //Insert into ROUTE table
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1001, '23:45', '101')");
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1002, '00:25', '580')");
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1003, '13:30', '140')");
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1004, '08:00', '280')");
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1005, '18:00', '880')");
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1006, '12:00', '420')");
            stmt.executeUpdate("INSERT INTO Route (bus_id, arrival_time, route_marker) VALUES (1007, '20:00', '505')");

            //Insert into RESERVATION table
            stmt.executeUpdate("INSERT INTO Reservation (reservation_id,cost,status,reservation_date,departure_date)\n" +
                    "VALUES(10001, 10, 'Booked', STR_TO_DATE('10-01-2021','%m-%d-%Y'), STR_TO_DATE('2021-11-22','%Y-%m-%d'))");

            stmt.executeUpdate("INSERT INTO Reservation (reservation_id,cost,status,reservation_date,departure_date) \n" +
                    " VALUES(10002, 20, 'Booked', STR_TO_DATE('10-02-2021','%m-%d-%Y'), STR_TO_DATE('2021-11-24','%Y-%m-%d'))");

            stmt.executeUpdate("INSERT INTO Reservation (reservation_id,cost,status,reservation_date,departure_date) \n" +
                    "VALUES(10003, 10, 'Waiting', STR_TO_DATE('09-01-2021','%m-%d-%Y'), STR_TO_DATE('2021-11-22','%Y-%m-%d'))");

            stmt.executeUpdate("INSERT INTO Reservation (reservation_id,cost,status,reservation_date,departure_date) \n" +
                    "VALUES(10004, 15, 'Cancelled', STR_TO_DATE('04-10-2021','%m-%d-%Y'), STR_TO_DATE('2021-11-25','%Y-%m-%d'))");

            stmt.executeUpdate("INSERT INTO Reservation (reservation_id,cost,status,reservation_date,departure_date) \n" +
                    "VALUES(10005, 40, 'Waiting', STR_TO_DATE('07-10-2021','%m-%d-%Y'), STR_TO_DATE('2021-11-26','%Y-%m-%d'))");

            //Insert into PASSENGER table
            stmt.executeUpdate("INSERT INTO Passenger (passenger_id, reservation_id, bus_id, name, email, age, gender) \n" +
                    "VALUES (1010, 10001, 1001, 'JOHN','john@gmail.com', 25,'M')");

            stmt.executeUpdate("INSERT INTO Passenger (passenger_id, reservation_id, bus_id, name, email, age, gender) \n" +
                    "VALUES (1011, 10002, 1002, 'MARTHA','martha@gmail.com', 45,'F')");

            stmt.executeUpdate("INSERT INTO Passenger (passenger_id, reservation_id, bus_id, name, email, age, gender) \n" +
                    "VALUES (1012, 10003, 1003, 'FRANK', 'frank@gmail.com', 29,'M')");

            stmt.executeUpdate("INSERT INTO Passenger (passenger_id, reservation_id, bus_id, name, email, age, gender) \n" +
                    "VALUES (1013,10004, 1004, 'RACHEL', 'rachel@gmail.com', 20, 'F')");

            stmt.executeUpdate("INSERT INTO Passenger (passenger_id, reservation_id, bus_id, name, email, age, gender) \n" +
                    "VALUES (1014,10005, 1005, 'HARRY', 'harry@gmail.com', 35, 'M' )");
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(1);
        }
    }


    public void displayTablesData() {

        try {

            ResultSet resultSet;
            Statement stmt = connection.createStatement();
            System.out.println("****************************************************"); System.out.println("Select * from Bus");
            resultSet = stmt.executeQuery("select * from Bus");

            displayBusData(resultSet);
            System.out.println("****************************************************");
            System.out.println("****************************************************");

            System.out.println("Select * from passenger");
            resultSet = stmt.executeQuery("select * from passenger");
            displayPassengerData(resultSet);
            System.out.println("****************************************************");
            System.out.println("****************************************************");

            System.out.println("Select * from route");
            resultSet = stmt.executeQuery("select * from route");
            displayRouteData(resultSet);
            System.out.println("****************************************************");
            System.out.println("****************************************************");

            System.out.println("Select * from reservation");
            resultSet = stmt.executeQuery("select * from reservation");
            displayReservationData(resultSet);
            System.out.println("****************************************************");
            System.out.println("****************************************************");

            System.out.println("Select * from bus_status");
            resultSet = stmt.executeQuery("select * from bus_status");
            displayBusStatusData(resultSet);
            System.out.println("*****************************************************");

        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(1);
        }
    }

    /**
     * Display Bus table data*/
    private void displayBusData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
        System.out.println("BusId: " + resultSet.getInt("bus_id") + " Bus Name: " + resultSet.getString("name")
                + " Source: " + resultSet.getString("source") + "Destination: " + resultSet.getString("destination"));
    }
    }
    /**
     * Display Passenger table data*/
    private void displayPassengerData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
        System.out.println("Passenger Id: " + resultSet.getInt("passenger_id") + " Bus Id: " + resultSet.getInt("bus_id")
                + " reservation id: " + resultSet.getInt("reservation_id") + " Name: " + resultSet.getString("name")
                + " Gender: " + resultSet.getString("gender") + " Age : " + resultSet.getInt("Age")
                + " Email: " + resultSet.getString("Email")); }
    }
    /**
     * Display Route table data */
    private void displayRouteData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
        System.out.println("Route Id: " + resultSet.getInt("route_id") + " Bus Id: " + resultSet.getInt("bus_id") + " Arrival time: "
                + resultSet.getString("Arrival_Time") + " Route marker: " + resultSet.getString("route_marker"));
    } }
    /**
     * Print Reservations table data */
    private void displayReservationData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
        System.out.println("Reservation Id: " + resultSet.getInt("reservation_id") + " Cost: " + resultSet.getInt("cost")
                + " Status: " + resultSet.getString("status") + " Departure date: " + resultSet.getDate("departure_date"));
    } }
    /**
     * Print Bus_Status table data*/
    private void displayBusStatusData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
        System.out.println("Bus Id: " + resultSet.getInt("bus_id") + " Available count: " + resultSet.getInt("AVAILABLE_SEATS")
                + " Booked count: " + resultSet.getInt("BOOKED_SEATS") + " Waiting_Count " + resultSet.getInt("WAIT_LISTED_SEATS")
                + " Bus Date: " + resultSet.getDate("BUS_DATE")); }
    }
}
