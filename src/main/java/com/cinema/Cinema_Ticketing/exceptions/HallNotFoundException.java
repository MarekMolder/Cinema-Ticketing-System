package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class HallNotFoundException extends CinemaTicketException {

    public HallNotFoundException(UUID hallId) {
        super("Hall not found with id: " + hallId);
    }
}
