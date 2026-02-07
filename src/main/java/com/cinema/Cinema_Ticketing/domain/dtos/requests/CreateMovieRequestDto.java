package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.entities.MovieTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequestDto {

    @NotBlank(message = "Movie name is required")
    private String name;

    @NotBlank(message = "Movie description is required")
    private String description;

    @NotEmpty(message = "Movie age rating is required")
    private Integer ageRating;

    @NotEmpty(message = "Movie type is required")
    private MovieTypeEnum movieType;

    @NotEmpty(message = "Movie duration is required")
    private Integer durationMin;

    private List<CreateScreeningRequest> screenings = new ArrayList<>();
}
