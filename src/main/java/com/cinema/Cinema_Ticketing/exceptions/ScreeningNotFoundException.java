package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class ScreeningNotFoundException extends CinemaTicketException {
    public ScreeningNotFoundException() {
    }

    public ScreeningNotFoundException(String message) {
        super(message);
    }

    public ScreeningNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScreeningNotFoundException(Throwable cause) {
        super(cause);
    }

    public ScreeningNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
