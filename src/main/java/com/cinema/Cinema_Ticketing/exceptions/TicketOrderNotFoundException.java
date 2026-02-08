package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class TicketOrderNotFoundException extends CinemaTicketException {
    public TicketOrderNotFoundException(UUID ticketOrderId) {
        super("Ticket order not found with id: " + ticketOrderId);
    }
}
