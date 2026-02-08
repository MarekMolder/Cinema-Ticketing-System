package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {TicketValidationMapper.class, QRCodeMapper.class})
public interface TicketMapper {

    CreateTicketRequest fromDto(CreateTicketRequestDto dto);

    CreateTicketResponseDto toDto(Ticket ticket);
}
