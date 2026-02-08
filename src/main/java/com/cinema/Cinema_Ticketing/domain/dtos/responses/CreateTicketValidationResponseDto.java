package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.MethodEnum;
import com.cinema.Cinema_Ticketing.domain.entities.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketValidationResponseDto {
    private UUID id;
    private LocalDateTime validatedAt;
    private MethodEnum method;
    private ResultEnum result;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
