package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScreeningRequestDto {

    @NotBlank(message = "Screening name is required")
    private String name;

    @NotNull(message = "Screening start time is required")
    private LocalDateTime startAt;

    @NotNull(message = "Screening end time is required")
    private LocalDateTime endAt;

    @NotNull(message = "Screening status is required")
    private ScreeningStatusEnum screeningStatus;

    @NotNull(message = "Movie ID is required")
    private UUID movieId;

    private UUID hallId;  // required when creating screenings from Movie context
}
