package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateCinemaRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;

public interface CinemaService {

    Cinema createCinema(CreateCinemaRequest request);
}
