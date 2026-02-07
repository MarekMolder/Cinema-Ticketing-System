package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateCinemaRequest;
import com.cinema.Cinema_Ticketing.domain.CreateHallRequest;
import com.cinema.Cinema_Ticketing.domain.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.CreateSeatRequest;
import com.cinema.Cinema_Ticketing.domain.entities.*;
import com.cinema.Cinema_Ticketing.exceptions.MovieNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.CinemaRepository;
import com.cinema.Cinema_Ticketing.repositories.MovieRepository;
import com.cinema.Cinema_Ticketing.services.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;

    @Override
    public Cinema createCinema(CreateCinemaRequest cinema) {
        Cinema cinemaToCreate = new Cinema();
        cinemaToCreate.setName(cinema.getName());

        List<Hall> hallsToCreate = cinema.getHalls().stream()
                .map(hallRequest -> createHallWithAssociations(hallRequest, cinemaToCreate))
                .toList();

        cinemaToCreate.setHalls(hallsToCreate);

        return cinemaRepository.save(cinemaToCreate);
    }

    private Hall createHallWithAssociations(CreateHallRequest hallRequest, Cinema cinema) {
        Hall hallToCreate = new Hall();
        hallToCreate.setName(hallRequest.getName());
        hallToCreate.setHallType(hallRequest.getHallType());
        hallToCreate.setHallStatus(hallRequest.getHallStatus());
        hallToCreate.setCinema(cinema);

        List<Seat> seats = createSeatsForHall(hallRequest.getSeats(), hallToCreate);
        hallToCreate.setSeats(seats);

        List<Screening> screenings = createScreeningsForHall(
                hallRequest.getScreenings(),
                hallToCreate,
                seats
        );
        hallToCreate.setScreenings(screenings);

        return hallToCreate;
    }

    private List<Seat> createSeatsForHall(List<CreateSeatRequest> seatRequests, Hall hall) {
        if (seatRequests == null) {
            return Collections.emptyList();
        }
        return seatRequests.stream()
                .map(seatRequest -> {
                    Seat seat = new Seat();
                    seat.setRow(seatRequest.getRow());
                    seat.setNumber(seatRequest.getNumber());
                    seat.setSeatType(seatRequest.getSeatType());
                    seat.setHall(hall);
                    return seat;
                })
                .toList();
    }

    private List<Screening> createScreeningsForHall(
            List<CreateScreeningRequest> screeningRequests,
            Hall hall,
            List<Seat> seats
    ) {
        if (screeningRequests == null || screeningRequests.isEmpty()) {
            return Collections.emptyList();
        }

        return screeningRequests.stream()
                .map(screeningRequest -> {
                    Movie movie = movieRepository.findById(screeningRequest.getMovieId())
                            .orElseThrow(() -> new MovieNotFoundException(screeningRequest.getMovieId()));

                    Screening screening = new Screening();
                    screening.setName(screeningRequest.getName());
                    screening.setStartAt(screeningRequest.getStartAt());
                    screening.setEndAt(screeningRequest.getEndAt());
                    screening.setScreeningStatus(screeningRequest.getScreeningStatus());
                    screening.setHall(hall);
                    screening.setMovie(movie);

                    List<ScreeningSeat> screeningSeats = createScreeningSeatsFromHallSeats(
                            seats,
                            screening
                    );
                    screening.setScreeningSeats(screeningSeats);

                    return screening;
                })
                .toList();
    }

    private List<ScreeningSeat> createScreeningSeatsFromHallSeats(List<Seat> seats, Screening screening) {
        List<ScreeningSeat> screeningSeats = new ArrayList<>();
        for (Seat seat : seats) {
            ScreeningSeat screeningSeat = new ScreeningSeat();
            screeningSeat.setScreeningSeatStatus(ScreeningSeatStatusEnum.AVAILABLE);
            screeningSeat.setHeldUntil(screening.getStartAt());
            screeningSeat.setSeat(seat);
            screeningSeat.setScreening(screening);
            screeningSeats.add(screeningSeat);
        }
        return screeningSeats;
    }
}
