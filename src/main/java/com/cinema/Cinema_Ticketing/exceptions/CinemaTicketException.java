package com.cinema.Cinema_Ticketing.exceptions;

public class CinemaTicketException extends  RuntimeException {

    public CinemaTicketException() {
    }

    public CinemaTicketException(String message) {
        super(message);
    }

    public CinemaTicketException(String message, Throwable cause) {
        super(message, cause);
    }

    public CinemaTicketException(Throwable cause) {
        super(cause);
    }

    public CinemaTicketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
