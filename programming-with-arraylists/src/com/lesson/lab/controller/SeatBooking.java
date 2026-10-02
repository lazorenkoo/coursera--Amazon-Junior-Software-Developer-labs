package com.lesson.lab.controller;

import com.lesson.lab.model.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        // TODO 1 : this.bookedSeatsList = ?
        this.bookedSeatsList = new ArrayList<>();
    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // TODO 2: check if the seat is already booked and not canceled
        boolean booked = false;
         for (Seat seat : bookedSeatsList) {
             if (seat.getSeatNumber().equals(seatNumber) && !seat.isCanceled()) {
                 System.out.println("Seat is already booked");
                 booked = true;
             }
         }
         if(!booked){
             Seat newSeat = new Seat(seatNumber);
             newSeat.setBooked(true);
             newSeat.setBookingDate(new Date(2026,10,10));
             bookedSeatsList.add(newSeat);
             System.out.println("Seat booked successfully");
         }
        // TODO 3 create a new Seat object for the booking,
        // mark the seat as booked,
        // set the current date as the booking date
        // TODO 4: add the new seat to the bookedSeatsList
        // TODO 5: confirm the booking to the user
     }
    // Method to cancel a booking
    public void cancelBooking(String seatNumber) {
        // TODO 6: iterate through the list of booked seats
        boolean found = false;
        for(Seat seat : bookedSeatsList){
            if(seat.getSeatNumber().equals(seatNumber) &&  !seat.isCanceled()){
                seat.setBooked(true);
                seat.setBooked(false);
                System.out.println("Seat cancelled successfully");
                found   = true;
            }
        }
        // TODO 7: check if the seat number matches and is not already canceled
        // mark the seat as canceled
        // mark the seat as not booked
        // confirm the cancellation to the user
        // TODO 8: inform the user if no booking was found for the seat number
        if(!found){
            System.out.println("no booking was found for this seat number");
        }
    }
    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        // TODO 9: iterate through the list of booked seats
        boolean found = false;

        for(Seat seat : bookedSeatsList){
            if(seat.getSeatNumber().equals(oldSeatNumber) && !seat.isCanceled()){
                seat.setSeatNumber(newSeatNumber);
                System.out.println("Seat updated successfully");
                found = true;
            }
        }
        if(!found){
            System.out.println("no booking was found for this seat number");
        }
        // TODO 10: check if the seat number matches the old seat number and is not canceled
        // TODO 11: update the seat number to the new seat number
        // confirm the update to the user
        // TODO 12: inform the user if no booking was found for the old seat number
    }
    // Method to display all bookings
    public void displayBookings() {
        if(bookedSeatsList.isEmpty()){
            System.out.println("There are no seats in the booked list");
        }
        else{
            for(Seat seat: bookedSeatsList){
                System.out.println(seat.getSeatNumber());
                System.out.println(seat.getBookingDate());

            }
        }
        // TODO 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        // TODO 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
        // TODO 15: display the seat number and booking date

    }
}
