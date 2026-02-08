package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateCinemaRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateCinemaRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateCinemaResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;
import com.cinema.Cinema_Ticketing.mappers.CinemaMapper;
import com.cinema.Cinema_Ticketing.services.CinemaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/cinemas")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaMapper cinemaMapper;
    private final CinemaService cinemaService;

    @PostMapping
    public ResponseEntity<CreateCinemaResponseDto> createCinema(
            @Valid @RequestBody CreateCinemaRequestDto createCinemaRequestDto) {
        CreateCinemaRequest createCinemaRequest = cinemaMapper.fromDto(createCinemaRequestDto);

        Cinema createdCinema = cinemaService.createCinema(createCinemaRequest);
        CreateCinemaResponseDto createdCinemaResponseDto = cinemaMapper.toDto(createdCinema);
        return new ResponseEntity<>(createdCinemaResponseDto, HttpStatus.CREATED);
    }

}
