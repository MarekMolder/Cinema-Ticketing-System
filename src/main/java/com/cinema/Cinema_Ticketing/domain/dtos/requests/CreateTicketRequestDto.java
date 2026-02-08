package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketRequestDto {

    @NotNull(message = "Ticket price is required")
    private BigDecimal price;

    @NotNull(message = "Ticket status is required")
    private TicketStatusEnum ticketStatus;

    @NotNull(message = "Seat ID is required")
    private UUID seatId;

    @NotNull(message = "QR Code is required")
    @Valid
    private CreateQRCodeRequestDto qrCode;
}
