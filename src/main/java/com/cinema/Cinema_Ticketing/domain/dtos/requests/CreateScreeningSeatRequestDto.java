package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeatStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScreeningSeatRequestDto {

    @NotNull(message = "Screening seat status is required")
    private ScreeningSeatStatusEnum screeningSeatStatus;

    @NotNull(message = "Screening seat held until time is required")
    private LocalDateTime heldUntil;
}
