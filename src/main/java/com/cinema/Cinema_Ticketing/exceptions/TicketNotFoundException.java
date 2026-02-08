package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class TicketNotFoundException extends CinemaTicketException{

    public TicketNotFoundException(UUID ticketId) {
        super("Ticket not found with id: " + ticketId);
    }
}
