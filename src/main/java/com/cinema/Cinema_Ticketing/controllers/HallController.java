package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateHallRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateHallRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateHallResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.mappers.HallMapper;
import com.cinema.Cinema_Ticketing.services.HallService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/cinemas/{cinemaId}/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallMapper hallMapper;
    private final HallService hallService;

    @PostMapping
    public ResponseEntity<CreateHallResponseDto> createHall(
            @PathVariable UUID cinemaId,
            @Valid @RequestBody CreateHallRequestDto createHallRequestDto) {

        CreateHallRequest createHallRequest = hallMapper.fromDto(createHallRequestDto);

        Hall createdHall = hallService.addHallToCinema(cinemaId, createHallRequest);
        CreateHallResponseDto createdHallResponseDto = hallMapper.toDto(createdHall);

        return new ResponseEntity<>(createdHallResponseDto, HttpStatus.CREATED);
    }
}
