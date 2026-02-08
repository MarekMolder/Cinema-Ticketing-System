package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateLinkRequest;
import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.entities.MovieTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieResponseDto {
    private UUID id;
    private String name;
    private String description;
    private Integer ageRating;
    private MovieTypeEnum movieType;
    private Integer durationMin;
    private List<CreateScreeningRequest> screenings = new ArrayList<>();
    private Set<CreateLinkRequest> links = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
