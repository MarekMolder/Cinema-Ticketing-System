package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedTicketOrderResponseDto {
    private UUID id;
    private BigDecimal totalPrice;
    private TicketOrderStatusEnum ticketOrderStatus;
    private List<CreatedTicketResponseDto> tickets = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
