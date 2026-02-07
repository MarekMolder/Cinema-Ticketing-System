package com.cinema.Cinema_Ticketing.domain;

import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketRequest {
    private BigDecimal price;
    private TicketStatusEnum ticketStatus;
    private List<CreateTicketValidationRequest> ticketValidations = new ArrayList<>();
    private CreateQRCodeRequest qrCode;
}
