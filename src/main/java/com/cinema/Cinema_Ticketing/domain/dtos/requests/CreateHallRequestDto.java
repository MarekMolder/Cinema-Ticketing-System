package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.HallStatusEnum;
import com.cinema.Cinema_Ticketing.domain.entities.HallTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHallRequestDto {

    @NotBlank(message = "Hall name is required")
    private String name;

    @NotNull(message = "Hall type is required")
    private HallTypeEnum hallType;

    @NotNull(message = "Hall status is required")
    private HallStatusEnum hallStatus;

    @NotEmpty(message = "At least one seat is required")
    @Valid
    private List<CreateSeatRequestDto> seats;

    private List<CreateScreeningRequestDto> screenings;
}
