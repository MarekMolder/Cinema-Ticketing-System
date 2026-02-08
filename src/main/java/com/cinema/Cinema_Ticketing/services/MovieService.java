package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.CreateMovieRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;

public interface MovieService {
    Movie createMovie(CreateMovieRequest request);
}
