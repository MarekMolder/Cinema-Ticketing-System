package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.CreateScreeningSeatRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;

import java.util.List;
import java.util.UUID;

public interface ScreeningSeatService {

    List<ScreeningSeat> createScreeningSeats(Screening screening, List<Seat> seats);

    ScreeningSeat addScreeningSeatToScreening(UUID screeningId, CreateScreeningSeatRequest request);
}
