package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.SeatTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSeatRequestDto {

    @NotNull(message = "Seat row is required")
    private Integer row;

    @NotNull(message = "Seat number is required")
    private Integer number;

    @NotEmpty(message = "Seat type is required")
    private SeatTypeEnum seatType;
}
