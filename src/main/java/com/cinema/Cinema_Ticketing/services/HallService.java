package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateHallRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;

import java.util.UUID;

public interface HallService {

    Hall createHall(Cinema cinema, CreateHallRequest request);

    Hall addHallToCinema(UUID cinemaId, CreateHallRequest request);
}
