package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.CreateSeatRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateSeatRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateSeatResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import com.cinema.Cinema_Ticketing.mappers.SeatMapper;
import com.cinema.Cinema_Ticketing.services.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/halls/{hallId}/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatMapper seatMapper;
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<CreateSeatResponseDto> createSeat(
            @PathVariable UUID hallId,
            @Valid @RequestBody CreateSeatRequestDto createSeatRequestDto) {

        CreateSeatRequest createSeatRequest = seatMapper.fromDto(createSeatRequestDto);

        Seat createdSeat = seatService.addSeatToHall(hallId, createSeatRequest);
        CreateSeatResponseDto createdSeatResponseDto = seatMapper.toDto(createdSeat);

        return new ResponseEntity<>(createdSeatResponseDto, HttpStatus.CREATED);
    }
}
