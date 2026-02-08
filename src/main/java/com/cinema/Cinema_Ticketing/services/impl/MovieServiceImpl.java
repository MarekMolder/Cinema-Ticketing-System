package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateMovieRequest;
import com.cinema.Cinema_Ticketing.domain.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Link;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.exceptions.HallNotFoundException;
import com.cinema.Cinema_Ticketing.exceptions.MovieNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.HallRepository;
import com.cinema.Cinema_Ticketing.repositories.MovieRepository;
import com.cinema.Cinema_Ticketing.repositories.ScreeningRepository;
import com.cinema.Cinema_Ticketing.services.LinkService;
import com.cinema.Cinema_Ticketing.services.MovieService;
import com.cinema.Cinema_Ticketing.services.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;
    private final ScreeningRepository screeningRepository;
    private final LinkService linkService;
    private final ScreeningService screeningService;

    @Override
    public Movie createMovie(CreateMovieRequest request) {
        Movie movie = new Movie();
        movie.setName(request.getName());
        movie.setDescription(request.getDescription());
        movie.setAgeRating(request.getAgeRating());
        movie.setMovieType(request.getMovieType());
        movie.setDurationMin(request.getDurationMin());

        Set<Link> links = linkService.createLinks(movie, request.getLinks());
        movie.setLinks(links);

        movie = movieRepository.save(movie);

        if (request.getScreenings() != null && !request.getScreenings().isEmpty()) {
            List<Screening> screenings = new ArrayList<>();
            for (CreateScreeningRequest screeningRequest : request.getScreenings()) {
                var hall = hallRepository.findById(screeningRequest.getHallId())
                        .orElseThrow(() -> new HallNotFoundException(screeningRequest.getHallId()));
                Screening screening = screeningService.createScreening(hall, screeningRequest, movie);
                screening = screeningRepository.save(screening);
                hall.getScreenings().add(screening);
                screenings.add(screening);
            }
            movie.setScreenings(screenings);
        }

        return movie;
    }
}
