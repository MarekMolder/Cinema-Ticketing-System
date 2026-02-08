package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.CreateTicketValidationRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import com.cinema.Cinema_Ticketing.domain.entities.TicketValidation;

import java.util.UUID;

public interface TicketValidationService {
    TicketValidation createTicketValidation(UUID staffId, Ticket ticket, CreateTicketValidationRequest request);

    TicketValidation addTicketValidationToTicket(UUID staffId, UUID ticketId, CreateTicketValidationRequest request);
}
