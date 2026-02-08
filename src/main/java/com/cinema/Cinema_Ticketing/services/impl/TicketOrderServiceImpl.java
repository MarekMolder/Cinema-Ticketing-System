package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.CreateTicketRequest;
import com.cinema.Cinema_Ticketing.domain.entities.*;
import com.cinema.Cinema_Ticketing.exceptions.*;
import com.cinema.Cinema_Ticketing.repositories.ScreeningRepository;
import com.cinema.Cinema_Ticketing.repositories.SeatRepository;
import com.cinema.Cinema_Ticketing.repositories.TicketOrderRepository;
import com.cinema.Cinema_Ticketing.repositories.UserRepository;
import com.cinema.Cinema_Ticketing.services.TicketOrderService;
import com.cinema.Cinema_Ticketing.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketOrderServiceImpl implements TicketOrderService {

    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final TicketOrderRepository ticketOrderRepository;
    private final TicketService ticketService;
    private final ScreeningRepository screeningRepository;

    @Override
    public TicketOrder createTicketOrder(UUID buyerId, Screening screening, CreateTicketOrderRequest request) {
        User buyer = userRepository.findById(buyerId)
                .orElseThrow(() -> new UserNotFoundException("User with ID '" + buyerId + "' not found"));

        TicketOrder ticketOrder = new TicketOrder();
        ticketOrder.setTotalPrice(request.getTotalPrice());
        ticketOrder.setTicketOrderStatus(request.getTicketOrderStatus());
        ticketOrder.setScreening(screening);
        ticketOrder.setUser(buyer);

        List<Ticket> tickets = request.getTickets().stream()
                .map(ticketRequest -> {
                    var seat = seatRepository.findById(ticketRequest.getSeatId())
                            .orElseThrow(() -> new SeatNotFoundException(ticketRequest.getSeatId()));
                    return ticketService.createTicket(ticketOrder, seat, ticketRequest);
                })
                .toList();

        ticketOrder.setTickets(tickets);

        return ticketOrderRepository.save(ticketOrder);
    }

    @Override
    public TicketOrder addTicketOrderToScreening(UUID buyerId, UUID screeningId, CreateTicketOrderRequest request) {
        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new ScreeningNotFoundException(screeningId));

        TicketOrder ticketOrder = createTicketOrder(buyerId, screening, request);
        screening.getTicketOrders().add(ticketOrder);

        return ticketOrder;
    }
}
