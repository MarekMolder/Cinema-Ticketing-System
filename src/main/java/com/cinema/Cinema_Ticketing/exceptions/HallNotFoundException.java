package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class HallNotFoundException extends CinemaTicketException {
    public HallNotFoundException() {
    }

    public HallNotFoundException(String message) {
        super(message);
    }

    public HallNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HallNotFoundException(Throwable cause) {
        super(cause);
    }

    public HallNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
