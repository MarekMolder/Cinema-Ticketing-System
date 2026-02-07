package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreatedTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {TicketMapper.class})
public interface TicketOrderMapper {

    CreatedTicketOrderResponseDto toDto(TicketOrder ticketOrder);
}
