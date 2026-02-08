package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketRequest {
    private BigDecimal price;
    private TicketStatusEnum ticketStatus;
    private UUID seatId;
    private CreateQRCodeRequest qrCode;
}
