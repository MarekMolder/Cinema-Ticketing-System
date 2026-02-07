package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.CreateTicketRequest;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Ticket order total price is required")
    private BigDecimal totalPrice;

    @NotEmpty(message = "Ticket order status is required")
    private TicketOrderStatusEnum ticketOrderStatus;


    private List<CreateTicketRequest> tickets = new ArrayList<>();
}
