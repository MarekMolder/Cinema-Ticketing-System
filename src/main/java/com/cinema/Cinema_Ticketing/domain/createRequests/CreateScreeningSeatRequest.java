package com.cinema.Cinema_Ticketing.domain.createRequests;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeatStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScreeningSeatRequest {
    private UUID seatId;
    private ScreeningSeatStatusEnum screeningSeatStatus;
    private LocalDateTime heldUntil;
}
