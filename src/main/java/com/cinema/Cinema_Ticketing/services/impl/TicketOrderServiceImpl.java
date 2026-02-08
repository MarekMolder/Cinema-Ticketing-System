package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.entities.*;
import com.cinema.Cinema_Ticketing.domain.updateRequests.UpdateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.exceptions.*;
import com.cinema.Cinema_Ticketing.repositories.ScreeningRepository;
import com.cinema.Cinema_Ticketing.repositories.SeatRepository;
import com.cinema.Cinema_Ticketing.repositories.TicketOrderRepository;
import com.cinema.Cinema_Ticketing.repositories.UserRepository;
import com.cinema.Cinema_Ticketing.services.TicketOrderService;
import com.cinema.Cinema_Ticketing.services.TicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                            .orElseThrow(() -> new SeatNotFoundException(
                                    String.format("Seat with ID '%s' does not exist", ticketRequest.getSeatId()))
                            );
                    return ticketService.createTicket(ticketOrder, seat, ticketRequest);
                })
                .toList();

        ticketOrder.setTickets(tickets);

        return ticketOrderRepository.save(ticketOrder);
    }

    @Override
    public TicketOrder addTicketOrderToScreening(UUID buyerId, UUID screeningId, CreateTicketOrderRequest request) {
        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new ScreeningNotFoundException(
                        String.format("Screening with ID '%s' does not exist", screeningId))
                );

        TicketOrder ticketOrder = createTicketOrder(buyerId, screening, request);
        screening.getTicketOrders().add(ticketOrder);

        return ticketOrder;
    }

    @Override
    public Page<TicketOrder> listTicketOrdersForBuyer(UUID buyerId, Pageable pageable) {
        return ticketOrderRepository.findByUserId(buyerId, pageable);
    }

    @Override
    public Page<TicketOrder> listTicketOrdersForScreening(UUID screeningId, Pageable pageable) {
        return ticketOrderRepository.findByScreeningId(screeningId, pageable);
    }

    @Override
    public Page<TicketOrder> listTicketOrders(Pageable pageable) {
        return ticketOrderRepository.findAll(pageable);
    }

    @Override
    public Optional<TicketOrder> getTicketOrderForBuyer(UUID id, UUID buyerId) {
        return ticketOrderRepository.findByIdAndUserId(id, buyerId);
    }

    @Override
    public Optional<TicketOrder> getTicketOrderForScreening(UUID id, UUID screeningId) {
        return ticketOrderRepository.findByIdAndScreeningId(id, screeningId);
    }

    @Override
    public Optional<TicketOrder> getTicketOrderForBuyerAndScreening(UUID id, UUID buyerId, UUID screeningId) {
        return ticketOrderRepository.findByIdAndUserIdAndScreeningId(id, buyerId, screeningId);
    }

    @Override
    public Optional<TicketOrder> getTicketOrder(UUID id) {
        return ticketOrderRepository.findById(id);
    }

    @Override
    @Transactional
    public TicketOrder updateTicketOrder(UUID id, UpdateTicketOrderRequest request) {
        if(request.getId() == null) {
            throw new TicketOrderUpdateException("Ticket order ID cannot be null");
        }

        if(!id.equals(request.getId())) {
            throw new TicketOrderUpdateException("Cannot update the ID of an order");
        }

        TicketOrder existingTicketOrder = ticketOrderRepository.findById(id)
                .orElseThrow(() -> new TicketOrderNotFoundException(
                        String.format("Ticket order with ID '%s' does not exist", id))
                );

        existingTicketOrder.setTicketOrderStatus(request.getTicketOrderStatus());

        return ticketOrderRepository.save(existingTicketOrder);
    }

    @Override
    @Transactional
    public void deleteTicketOrder(UUID id) {
        TicketOrder ticketOrder = ticketOrderRepository.findById(id)
                .orElseThrow(() -> new TicketOrderNotFoundException(
                        String.format("Ticket order with ID '%s' does not exist", id)));
        ticketOrderRepository.delete(ticketOrder);
    }
}
