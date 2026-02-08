package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class ScreeningNotFoundException extends CinemaTicketException {
    public ScreeningNotFoundException(UUID screeningId) {
        super("Screening not found with id: " + screeningId);
    }
}
