package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class SeatNotFoundException extends CinemaTicketException {

    public SeatNotFoundException(UUID seatId) {
        super("Seat not found with id: " + seatId);
    }
}
