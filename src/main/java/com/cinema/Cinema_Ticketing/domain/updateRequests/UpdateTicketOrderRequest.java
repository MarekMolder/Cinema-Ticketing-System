package com.cinema.Cinema_Ticketing.domain.updateRequests;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketOrderRequest {
    private UUID id;
    private TicketOrderStatusEnum ticketOrderStatus;
}
