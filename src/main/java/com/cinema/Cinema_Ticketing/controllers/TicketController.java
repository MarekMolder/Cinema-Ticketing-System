package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.CreateTicketRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import com.cinema.Cinema_Ticketing.mappers.TicketMapper;
import com.cinema.Cinema_Ticketing.services.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/ticket-orders/{orderId}/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketMapper ticketMapper;
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<CreateTicketResponseDto> createTicket(
            @PathVariable UUID orderId,
            @Valid @RequestBody CreateTicketRequestDto createTicketRequestDto) {

        CreateTicketRequest createTicketRequest = ticketMapper.fromDto(createTicketRequestDto);

        Ticket createdTicket = ticketService.addTicketToTicketOrder(orderId, createTicketRequest);
        CreateTicketResponseDto createdTicketResponseDto = ticketMapper.toDto(createdTicket);

        return new ResponseEntity<>(createdTicketResponseDto, HttpStatus.CREATED);
    }
}
