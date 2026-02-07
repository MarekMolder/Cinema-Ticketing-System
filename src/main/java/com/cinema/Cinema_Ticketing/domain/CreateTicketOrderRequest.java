package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketOrderRequest {
    private BigDecimal totalPrice;
    private TicketOrderStatusEnum ticketOrderStatus;
    private List<CreateTicketRequest> tickets = new ArrayList<>();
}
