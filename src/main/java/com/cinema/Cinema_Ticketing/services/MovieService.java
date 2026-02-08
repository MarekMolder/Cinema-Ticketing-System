package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateMovieRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;

public interface MovieService {
    Movie createMovie(CreateMovieRequest request);
}
