package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeatStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedScreeningSeatResponseDto {
    private UUID id;
    private ScreeningSeatStatusEnum screeningSeatStatus;
    private LocalDateTime heldUntil;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
