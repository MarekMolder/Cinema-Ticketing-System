package com.cinema.Cinema_Ticketing.domain.dtos.updateRequest;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketOrderRequestDto {

    @NotNull(message = "TicketOrder Id must be provided")
    private UUID id;

    @NotNull(message = "Ticket order status is required")
    private TicketOrderStatusEnum ticketOrderStatus;
}
