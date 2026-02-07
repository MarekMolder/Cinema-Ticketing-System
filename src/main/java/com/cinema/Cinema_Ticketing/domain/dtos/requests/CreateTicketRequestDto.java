package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.CreateQRCodeRequest;
import com.cinema.Cinema_Ticketing.domain.CreateTicketValidationRequest;
import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketRequestDto {

    @NotEmpty(message = "Ticket price is required")
    private BigDecimal price;

    @NotEmpty(message = "Ticket status is required")
    private TicketStatusEnum ticketStatus;


    private List<CreateTicketValidationRequest> ticketValidations = new ArrayList<>();


    private CreateQRCodeRequestDto qrCode;
}
