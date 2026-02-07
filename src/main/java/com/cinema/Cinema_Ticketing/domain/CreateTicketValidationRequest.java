package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.MethodEnum;
import com.cinema.Cinema_Ticketing.domain.entities.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketValidationRequest {
    private LocalDateTime validatedAt;
    private MethodEnum method;
    private ResultEnum result;
}
