package com.cinema.Cinema_Ticketing.domain.dtos.updateResponse;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketOrderResponseDto {
    private UUID id;
    private TicketOrderStatusEnum ticketOrderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
