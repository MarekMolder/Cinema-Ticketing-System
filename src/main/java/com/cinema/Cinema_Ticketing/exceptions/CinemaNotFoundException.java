package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class CinemaNotFoundException extends CinemaTicketException {

    public CinemaNotFoundException(UUID cinemaId) {
        super("Cinema not found with id: " + cinemaId);
    }
}
