package com.bus.reservation;

import com.bus.reservation.app.DbSetup;

/**
 * Bus Reservation App!
 *
 */
public class BusReservationApp {

    public static void main( String[] args ) {

        System.out.println("Application Started");

        DbSetup dbSetup = new DbSetup();
        dbSetup.setUpTables();
        dbSetup.insertData();
        dbSetup.displayTablesData();
    }
}
