package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import com.cinema.Cinema_Ticketing.exceptions.HallNotFoundException;
import com.cinema.Cinema_Ticketing.exceptions.MovieNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.HallRepository;
import com.cinema.Cinema_Ticketing.repositories.MovieRepository;
import com.cinema.Cinema_Ticketing.repositories.ScreeningRepository;
import com.cinema.Cinema_Ticketing.services.ScreeningSeatService;
import com.cinema.Cinema_Ticketing.services.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningSeatService screeningSeatService;
    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;
    private final ScreeningRepository screeningRepository;

    @Override
    public Screening createScreening(Hall hall, CreateScreeningRequest request, Movie movie) {
        Screening screening = new Screening();
        screening.setName(request.getName());
        screening.setStartAt(request.getStartAt());
        screening.setEndAt(request.getEndAt());
        screening.setScreeningStatus(request.getScreeningStatus());
        screening.setHall(hall);
        screening.setMovie(movie);

        List<ScreeningSeat> screeningSeats = screeningSeatService.createScreeningSeats(screening, hall.getSeats());
        screening.setScreeningSeats(screeningSeats);

        return screeningRepository.save(screening);
    }

    @Override
    public List<Screening> createScreenings(Hall hall, List<CreateScreeningRequest> screeningRequests) {
        if (screeningRequests == null || screeningRequests.isEmpty()) {
            return Collections.emptyList();
        }

        return screeningRequests.stream()
                .map(request -> {
                    Movie movie = movieRepository.findById(request.getMovieId())
                            .orElseThrow(() -> new MovieNotFoundException(request.getMovieId()));
                    return createScreening(hall, request, movie);
                })
                .toList();
    }

    @Override
    public Screening addScreeningToHall(UUID hallId, CreateScreeningRequest screeningRequest) {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new HallNotFoundException(hallId));

        Movie movie = movieRepository.findById(screeningRequest.getMovieId())
                .orElseThrow(() -> new MovieNotFoundException(screeningRequest.getMovieId()));

        Screening screening = createScreening(hall, screeningRequest, movie);
        hall.getScreenings().add(screening);

        return screening;
    }
}
