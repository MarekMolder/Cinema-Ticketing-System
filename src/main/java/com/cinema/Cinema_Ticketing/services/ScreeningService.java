package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;

import java.util.List;
import java.util.UUID;

public interface ScreeningService {

    Screening createScreening(Hall hall, CreateScreeningRequest request, Movie movie);

    List<Screening> createScreenings(Hall hall, List<CreateScreeningRequest> screeningRequests);

    Screening addScreeningToHall(UUID hallId, CreateScreeningRequest screeningRequest);
}
