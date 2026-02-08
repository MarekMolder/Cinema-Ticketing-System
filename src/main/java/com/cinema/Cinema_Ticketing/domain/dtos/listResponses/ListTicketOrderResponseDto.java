package com.cinema.Cinema_Ticketing.domain.dtos.listResponses;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListTicketOrderResponseDto {

    private UUID id;
    private BigDecimal totalPrice;
    private TicketOrderStatusEnum ticketOrderStatus;
    private List<ListTicketResponseDto> tickets = new ArrayList<>();
}
