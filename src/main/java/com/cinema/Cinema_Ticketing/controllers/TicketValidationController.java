package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketValidationRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketValidationRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketValidationResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketValidation;
import com.cinema.Cinema_Ticketing.mappers.TicketValidationMapper;
import com.cinema.Cinema_Ticketing.services.TicketValidationService;
import com.cinema.Cinema_Ticketing.util.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tickets/{ticketId}/validations")
@RequiredArgsConstructor
public class TicketValidationController {
    
    private final TicketValidationMapper ticketValidationMapper;
    private final TicketValidationService ticketValidationService;

    @PostMapping
    public ResponseEntity<CreateTicketValidationResponseDto> createTicketValidation(
            @PathVariable UUID ticketId,
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateTicketValidationRequestDto createTicketValidationRequestDto) {

        UUID userId = JwtHelper.parseUserId(jwt);

        CreateTicketValidationRequest createTicketValidationRequest = ticketValidationMapper.fromDto(createTicketValidationRequestDto);

        TicketValidation createdTicketValidation = ticketValidationService.addTicketValidationToTicket(userId, ticketId, createTicketValidationRequest);
        CreateTicketValidationResponseDto createTicketValidationResponseDto = ticketValidationMapper.toDto(createdTicketValidation);
        return new ResponseEntity<>(createTicketValidationResponseDto, HttpStatus.CREATED);
    }
}
