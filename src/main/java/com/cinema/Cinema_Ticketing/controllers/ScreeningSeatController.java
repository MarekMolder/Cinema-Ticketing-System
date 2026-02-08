package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningSeatRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateScreeningSeatRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateScreeningSeatResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import com.cinema.Cinema_Ticketing.mappers.ScreeningSeatMapper;
import com.cinema.Cinema_Ticketing.services.ScreeningSeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/screenings/{screeningId}/screening-seats")
@RequiredArgsConstructor
public class ScreeningSeatController {

    private final ScreeningSeatMapper screeningSeatMapper;
    private final ScreeningSeatService screeningSeatService;

    @PostMapping
    public ResponseEntity<CreateScreeningSeatResponseDto> createScreeningSeat(
            @PathVariable UUID screeningId,
            @Valid @RequestBody CreateScreeningSeatRequestDto createScreeningSeatRequestDto) {

        CreateScreeningSeatRequest createScreeningSeatRequest = screeningSeatMapper.fromDto(createScreeningSeatRequestDto);
        ScreeningSeat createdScreeningSeat = screeningSeatService.addScreeningSeatToScreening(screeningId, createScreeningSeatRequest);
        CreateScreeningSeatResponseDto createdScreeningSeatResponseDto = screeningSeatMapper.toDto(createdScreeningSeat);
        return new ResponseEntity<>(createdScreeningSeatResponseDto, HttpStatus.CREATED);
    }
}
