package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;

import java.util.UUID;

public interface TicketService {
    Ticket createTicket(TicketOrder ticketOrder, Seat seat, CreateTicketRequest request);

    Ticket addTicketToTicketOrder(UUID orderId, CreateTicketRequest request);
}
