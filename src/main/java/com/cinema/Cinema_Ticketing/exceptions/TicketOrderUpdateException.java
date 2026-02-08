package com.cinema.Cinema_Ticketing.exceptions;

public class TicketOrderUpdateException extends CinemaTicketException {
    public TicketOrderUpdateException() {
    }

    public TicketOrderUpdateException(String message) {
        super(message);
    }

    public TicketOrderUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketOrderUpdateException(Throwable cause) {
        super(cause);
    }

    public TicketOrderUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
