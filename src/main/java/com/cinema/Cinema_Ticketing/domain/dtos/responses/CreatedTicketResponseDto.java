package com.cinema.Cinema_Ticketing.domain.dtos.responses;

import com.cinema.Cinema_Ticketing.domain.entities.TicketStatusEnum;
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
public class CreatedTicketResponseDto {
    private UUID id;
    private BigDecimal price;
    private TicketStatusEnum ticketStatus;
    private List<CreatedTicketValidationResponseDto> ticketValidations = new ArrayList<>();
    private CreateQRCodeResponseDto qrCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
