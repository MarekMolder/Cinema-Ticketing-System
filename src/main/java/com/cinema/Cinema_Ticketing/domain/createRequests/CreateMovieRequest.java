package com.cinema.Cinema_Ticketing.domain.createRequests;

import com.cinema.Cinema_Ticketing.domain.entities.MovieTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {
    private String name;
    private String description;
    private Integer ageRating;
    private MovieTypeEnum movieType;
    private Integer durationMin;
    private List<CreateScreeningRequest> screenings = new ArrayList<>();
    private Set<CreateLinkRequest> links = new HashSet<>();
}
