package com.cinema.Cinema_Ticketing.exceptions;

import java.util.UUID;

public class MovieNotFoundException extends CinemaTicketException {

    public MovieNotFoundException(UUID movieId) {
        super("Movie not found with id: " + movieId);
    }
}
