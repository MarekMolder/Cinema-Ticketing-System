package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketOrderRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {TicketMapper.class})
public interface TicketOrderMapper {

    CreateTicketOrderRequest fromDto(CreateTicketOrderRequestDto dto);

    CreateTicketOrderResponseDto toDto(TicketOrder ticketOrder);
}
