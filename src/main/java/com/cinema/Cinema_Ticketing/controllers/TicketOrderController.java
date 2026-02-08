package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketOrderRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import com.cinema.Cinema_Ticketing.mappers.TicketOrderMapper;
import com.cinema.Cinema_Ticketing.services.TicketOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/screenings/{screeningId}/ticket-orders")
@RequiredArgsConstructor
public class TicketOrderController {

    private final TicketOrderMapper ticketOrderMapper;
    private final TicketOrderService ticketOrderService;

    @PostMapping
    public ResponseEntity<CreateTicketOrderResponseDto> createTicketOrder(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID screeningId,
            @Valid @RequestBody CreateTicketOrderRequestDto createTicketOrderRequestDto) {

        UUID userId = UUID.fromString(jwt.getSubject());

        CreateTicketOrderRequest createTicketOrderRequest = ticketOrderMapper.fromDto(createTicketOrderRequestDto);

        TicketOrder createdTicketOrder = ticketOrderService.addTicketOrderToScreening(userId, screeningId, createTicketOrderRequest);
        CreateTicketOrderResponseDto createTicketOrderResponseDto = ticketOrderMapper.toDto(createdTicketOrder);
        return new ResponseEntity<>(createTicketOrderResponseDto, HttpStatus.CREATED);
    }
}
