package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;

import java.util.UUID;

public interface TicketOrderService {
    TicketOrder createTicketOrder(UUID buyerId, Screening screening, CreateTicketOrderRequest ticketOrder);

    TicketOrder addTicketOrderToScreening(UUID buyerId, UUID screeningId, CreateTicketOrderRequest request);
}
