package com.cinema.Cinema_Ticketing.domain.dtos.detailResponses;

import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
import com.cinema.Cinema_Ticketing.domain.entities.TicketValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTicketResponseDto {
    private UUID id;
    private BigDecimal price;
    private TicketStatusEnum ticketStatus;
    private List<TicketValidation> ticketValidations = new ArrayList<>();
    private QRCode qrCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
