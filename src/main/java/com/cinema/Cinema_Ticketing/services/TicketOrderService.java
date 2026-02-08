package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import com.cinema.Cinema_Ticketing.domain.updateRequests.UpdateTicketOrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface TicketOrderService {
    TicketOrder createTicketOrder(UUID buyerId, Screening screening, CreateTicketOrderRequest ticketOrder);

    TicketOrder addTicketOrderToScreening(UUID buyerId, UUID screeningId, CreateTicketOrderRequest request);

    Page<TicketOrder> listTicketOrdersForBuyer(UUID buyerId, Pageable pageable);

    Page<TicketOrder> listTicketOrdersForScreening(UUID screeningId, Pageable pageable);

    Page<TicketOrder> listTicketOrders(Pageable pageable);

    Optional<TicketOrder> getTicketOrderForBuyer(UUID id, UUID buyerId);

    Optional<TicketOrder> getTicketOrderForScreening(UUID id, UUID screeningId);

    Optional<TicketOrder> getTicketOrderForBuyerAndScreening(UUID id, UUID buyerId, UUID screeningId);

    Optional<TicketOrder> getTicketOrder(UUID id);

    TicketOrder updateTicketOrder(UUID id, UpdateTicketOrderRequest request);

    void deleteTicketOrder(UUID id);
}
