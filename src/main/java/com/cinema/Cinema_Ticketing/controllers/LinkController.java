package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateLinkRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateLinkRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateLinkResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Link;
import com.cinema.Cinema_Ticketing.mappers.LinkMapper;
import com.cinema.Cinema_Ticketing.services.LinkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/movies/{movieId}/links")
@RequiredArgsConstructor
public class LinkController {

    private final LinkMapper linkMapper;
    private final LinkService linkService;

    @PostMapping
    public ResponseEntity<CreateLinkResponseDto> createLink(
            @PathVariable UUID movieId,
            @Valid @RequestBody CreateLinkRequestDto createLinkRequestDto) {

        CreateLinkRequest createLinkRequest = linkMapper.fromDto(createLinkRequestDto);

        Link createdLink = linkService.addLinkToMovie(movieId, createLinkRequest);
        CreateLinkResponseDto createdLinkResponseDto = linkMapper.toDto(createdLink);

        return new ResponseEntity<>(createdLinkResponseDto, HttpStatus.CREATED);
    }
}
