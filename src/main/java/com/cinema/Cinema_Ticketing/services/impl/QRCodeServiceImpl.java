package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateQRCodeRequest;
import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import com.cinema.Cinema_Ticketing.exceptions.TicketNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.QRCodeRepository;
import com.cinema.Cinema_Ticketing.repositories.TicketRepository;
import com.cinema.Cinema_Ticketing.services.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QRCodeServiceImpl implements QRCodeService {

    private final QRCodeRepository qrCodeRepository;
    private final TicketRepository ticketRepository;

    @Override
    public QRCode createQRCode(Ticket ticket, CreateQRCodeRequest request) {
        QRCode qrCode = new QRCode();
        qrCode.setCodeValue(request.getCodeValue());
        qrCode.setCodeStatus(request.getCodeStatus());
        qrCode.setTicket(ticket);

        return qrCodeRepository.save(qrCode);
    }

    @Override
    public QRCode addQRCodeToTicket(UUID ticketId, CreateQRCodeRequest request) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));
        QRCode qrCode = createQRCode(ticket, request);
        ticket.setQrCode(qrCode);
        return qrCode;
    }
}