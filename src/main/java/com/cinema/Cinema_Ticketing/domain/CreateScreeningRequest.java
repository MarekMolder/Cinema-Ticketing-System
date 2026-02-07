package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScreeningRequest {
    private String name;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private ScreeningStatusEnum screeningStatus;
    private UUID movieId;
}
