package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScreeningResponseDto {
    private UUID id;
    private String name;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private ScreeningStatusEnum screeningStatus;
    private UUID movieId;
    private List<CreatedTicketOrderResponseDto> ticketOrders = new ArrayList<>();
    private List<CreatedScreeningSeatResponseDto> screeningSeats = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
