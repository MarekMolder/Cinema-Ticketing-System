package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class SeatNotFoundException extends CinemaTicketException {
    public SeatNotFoundException() {
    }

    public SeatNotFoundException(String message) {
        super(message);
    }

    public SeatNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatNotFoundException(Throwable cause) {
        super(cause);
    }

    public SeatNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
