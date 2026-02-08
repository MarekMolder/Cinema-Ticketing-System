package com.cinema.Cinema_Ticketing.domain.createRequests;

import com.cinema.Cinema_Ticketing.domain.entities.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSeatRequest {
    private Integer row;
    private Integer number;
    private SeatTypeEnum seatType;
}
