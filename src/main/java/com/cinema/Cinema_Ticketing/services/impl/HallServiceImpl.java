package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateHallRequest;
import com.cinema.Cinema_Ticketing.domain.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import com.cinema.Cinema_Ticketing.exceptions.CinemaNotFoundException;
import com.cinema.Cinema_Ticketing.exceptions.MovieNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.CinemaRepository;
import com.cinema.Cinema_Ticketing.repositories.HallRepository;
import com.cinema.Cinema_Ticketing.repositories.MovieRepository;
import com.cinema.Cinema_Ticketing.services.HallService;
import com.cinema.Cinema_Ticketing.services.ScreeningService;
import com.cinema.Cinema_Ticketing.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final CinemaRepository cinemaRepository;
    private final SeatService seatService;
    private final ScreeningService screeningService;
    private final HallRepository hallRepository;

    @Override
    public Hall createHall(Cinema cinema, CreateHallRequest request) {
        Hall hall = new Hall();
        hall.setName(request.getName());
        hall.setHallType(request.getHallType());
        hall.setHallStatus(request.getHallStatus());
        hall.setCinema(cinema);

        List<Seat> seats = seatService.createSeats(hall, request.getSeats());
        hall.setSeats(seats);

        List<Screening> screenings = screeningService.createScreenings(hall, request.getScreenings());
        hall.setScreenings(screenings);

        return hallRepository.save(hall);
    }

    @Override
    public Hall addHallToCinema(UUID cinemaId, CreateHallRequest request) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException(cinemaId));
        Hall hall = createHall(cinema, request);
        cinema.getHalls().add(hall);
        return hall;
    }
}
