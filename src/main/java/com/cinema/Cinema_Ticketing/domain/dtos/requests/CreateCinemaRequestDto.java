package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCinemaRequestDto {

    @NotBlank(message = "Cinema name is required")
    private String name;

    @NotEmpty(message = "At least one hall is required")
    @Valid
    private List<CreateHallRequestDto> halls;
}
