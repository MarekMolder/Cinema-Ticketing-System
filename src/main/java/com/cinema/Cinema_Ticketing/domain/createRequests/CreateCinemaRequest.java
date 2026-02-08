package com.cinema.Cinema_Ticketing.domain.createRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCinemaRequest {
    private String name;
    private List<CreateHallRequest> halls = new ArrayList<>();
}
