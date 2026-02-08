package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketOrderRequestDto {

    @NotNull(message = "Ticket order total price is required")
    private BigDecimal totalPrice;

    @NotNull(message = "Ticket order status is required")
    private TicketOrderStatusEnum ticketOrderStatus;

    @NotEmpty(message = "At least one ticket is required")
    @Valid
    private List<CreateTicketRequestDto> tickets = new ArrayList<>();
}
