package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSeatResponseDto {
    private UUID id;
    private Integer row;
    private Integer number;
    private SeatTypeEnum seatType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
