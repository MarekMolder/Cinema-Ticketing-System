package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateTicketRequest;
import com.cinema.Cinema_Ticketing.domain.entities.*;
import com.cinema.Cinema_Ticketing.exceptions.*;
import com.cinema.Cinema_Ticketing.repositories.SeatRepository;
import com.cinema.Cinema_Ticketing.repositories.TicketOrderRepository;
import com.cinema.Cinema_Ticketing.repositories.TicketRepository;
import com.cinema.Cinema_Ticketing.services.QRCodeService;
import com.cinema.Cinema_Ticketing.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final QRCodeService qrCodeService;
    private final TicketRepository ticketRepository;
    private final TicketOrderRepository ticketOrderRepository;
    private final SeatRepository seatRepository;

    @Override
    public Ticket createTicket(TicketOrder ticketOrder, Seat seat, CreateTicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setPrice(request.getPrice());
        ticket.setTicketStatus(request.getTicketStatus());
        ticket.setTicketOrder(ticketOrder);
        ticket.setSeat(seat);

        QRCode qrCode = qrCodeService.createQRCode(ticket, request.getQrCode());
        ticket.setQrCode(qrCode);

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket addTicketToTicketOrder(UUID orderId, CreateTicketRequest request) {
        TicketOrder ticketOrder = ticketOrderRepository.findById(orderId)
                .orElseThrow(() -> new TicketOrderNotFoundException(orderId));

        Seat seat = seatRepository.findById(request.getSeatId())
                .orElseThrow(() -> new SeatNotFoundException(request.getSeatId()));

        Ticket ticket = createTicket(ticketOrder, seat, request);
        ticketOrder.getTickets().add(ticket);

        return ticket;
    }
}
