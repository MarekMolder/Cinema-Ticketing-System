package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.HallStatusEnum;
import com.cinema.Cinema_Ticketing.domain.entities.HallTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHallRequest {
    private String name;
    private HallTypeEnum hallType;
    private HallStatusEnum hallStatus;
    private List<CreateSeatRequest> seats = new ArrayList<>();
    private List<CreateScreeningRequest> screenings = new ArrayList<>();
}
