package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.CreateSeatRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;

import java.util.List;
import java.util.UUID;

public interface SeatService {

    Seat createSeat(Hall hall, CreateSeatRequest request);

    List<Seat> createSeats(Hall hall, List<CreateSeatRequest> seatRequests);

    Seat addSeatToHall(UUID hallId, CreateSeatRequest request);
}
