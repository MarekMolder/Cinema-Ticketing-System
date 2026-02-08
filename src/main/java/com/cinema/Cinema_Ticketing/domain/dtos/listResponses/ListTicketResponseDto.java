package com.cinema.Cinema_Ticketing.domain.dtos.listResponses;

import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
import com.cinema.Cinema_Ticketing.domain.entities.TicketValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListTicketResponseDto {

    private UUID id;
    private BigDecimal price;
    private TicketStatusEnum ticketStatus;
    private Seat seat;
    private List<TicketValidation> ticketValidations = new ArrayList<>();
    private QRCode qrCode;
}
