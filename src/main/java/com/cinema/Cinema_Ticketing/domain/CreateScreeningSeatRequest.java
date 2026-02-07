package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeatStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScreeningSeatRequest {
    private ScreeningSeatStatusEnum screeningSeatStatus;
    private LocalDateTime heldUntil;
}
