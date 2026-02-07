package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.HallStatusEnum;
import com.cinema.Cinema_Ticketing.domain.entities.HallTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHallResponseDto {
    private UUID id;
    private String name;
    private HallTypeEnum hallType;
    private HallStatusEnum hallStatus;
    private List<CreateSeatResponseDto> seats;
    private List<CreateScreeningResponseDto> screenings;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
