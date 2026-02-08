package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketValidationRequest;
import com.cinema.Cinema_Ticketing.domain.entities.*;
import com.cinema.Cinema_Ticketing.exceptions.TicketNotFoundException;
import com.cinema.Cinema_Ticketing.exceptions.UserNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.TicketRepository;
import com.cinema.Cinema_Ticketing.repositories.TicketValidationRepository;
import com.cinema.Cinema_Ticketing.repositories.UserRepository;
import com.cinema.Cinema_Ticketing.services.TicketValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketValidationServiceImpl implements TicketValidationService {

    private final UserRepository userRepository;
    private final TicketValidationRepository ticketValidationRepository;
    private final TicketRepository ticketRepository;

    @Override
    public TicketValidation createTicketValidation(UUID staffId, Ticket ticket, CreateTicketValidationRequest request) {
        User staff = userRepository.findById(staffId)
                .orElseThrow(() -> new UserNotFoundException("User with ID '" + staffId + "' not found"));

        TicketValidation ticketValidation = new TicketValidation();
        ticketValidation.setValidatedAt(request.getValidatedAt());
        ticketValidation.setMethod(request.getMethod());
        ticketValidation.setResult(request.getResult());
        ticketValidation.setTicket(ticket);
        ticketValidation.setUser(staff);

        return ticketValidationRepository.save(ticketValidation);
    }

    @Override
    public TicketValidation addTicketValidationToTicket(UUID staffId, UUID ticketId, CreateTicketValidationRequest request) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));

        TicketValidation ticketValidation = createTicketValidation(staffId, ticket, request);
        ticket.getTicketValidations().add(ticketValidation);

        return ticketValidation;
    }
}
