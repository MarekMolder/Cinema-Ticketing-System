package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.CreateQRCodeRequest;
import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;

import java.util.UUID;

public interface QRCodeService {
    QRCode createQRCode(Ticket ticket, CreateQRCodeRequest request);

    QRCode addQRCodeToTicket(UUID ticketId, CreateQRCodeRequest request);
}
