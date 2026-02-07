package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreatedTicketResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {TicketValidationMapper.class, QRCodeMapper.class})
public interface TicketMapper {

    CreatedTicketResponseDto toDto(Ticket ticket);
}
