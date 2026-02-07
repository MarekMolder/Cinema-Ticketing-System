package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.MethodEnum;
import com.cinema.Cinema_Ticketing.domain.entities.ResultEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketValidationRequestDto {

    @NotEmpty(message = "Ticket validation time is required")
    private LocalDateTime validatedAt;

    @NotEmpty(message = "Ticket validation method is required")
    private MethodEnum method;

    @NotEmpty(message = "Ticket validation result is required")
    private ResultEnum result;
}
