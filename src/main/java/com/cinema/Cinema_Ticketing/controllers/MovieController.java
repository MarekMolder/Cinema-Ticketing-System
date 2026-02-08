package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.CreateMovieRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateMovieRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateMovieResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import com.cinema.Cinema_Ticketing.mappers.MovieMapper;
import com.cinema.Cinema_Ticketing.services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieMapper movieMapper;
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<CreateMovieResponseDto> createMovie(
            @Valid @RequestBody CreateMovieRequestDto createMovieRequestDto) {

        CreateMovieRequest createMovieRequest = movieMapper.fromDto(createMovieRequestDto);

        Movie createdMovie = movieService.createMovie(createMovieRequest);
        CreateMovieResponseDto createdMovieResponseDto = movieMapper.toDto(createdMovie);

        return new ResponseEntity<>(createdMovieResponseDto, HttpStatus.CREATED);
    }
}
