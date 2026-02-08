package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateScreeningRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateScreeningResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.mappers.ScreeningMapper;
import com.cinema.Cinema_Ticketing.services.ScreeningService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/halls/{hallId}/screenings")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningMapper screeningMapper;
    private final ScreeningService screeningService;

    @PostMapping
    public ResponseEntity<CreateScreeningResponseDto> createScreening(
            @PathVariable UUID hallId,
            @Valid @RequestBody CreateScreeningRequestDto createScreeningRequestDto) {

        CreateScreeningRequest createScreeningRequest = screeningMapper.fromDto(createScreeningRequestDto);
        Screening createdScreening = screeningService.addScreeningToHall(hallId, createScreeningRequest);

        CreateScreeningResponseDto createdScreeningResponseDto = screeningMapper.toDto(createdScreening);
        return new ResponseEntity<>(createdScreeningResponseDto, HttpStatus.CREATED);
    }
}