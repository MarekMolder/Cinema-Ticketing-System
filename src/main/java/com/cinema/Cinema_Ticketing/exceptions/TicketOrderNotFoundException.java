package com.cinema.Cinema_Ticketing.exceptions;

public class TicketOrderNotFoundException extends CinemaTicketException {

    public TicketOrderNotFoundException() {
    }

    public TicketOrderNotFoundException(String message) {
        super(message);
    }

    public TicketOrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketOrderNotFoundException(Throwable cause) {
        super(cause);
    }

    public TicketOrderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
