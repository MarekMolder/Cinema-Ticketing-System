package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.dtos.detailResponses.GetTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.detailResponses.GetTicketResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.listResponses.ListTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.listResponses.ListTicketResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.updateRequest.UpdateTicketOrderRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.updateResponse.UpdateTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Ticket;
import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketOrderRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import com.cinema.Cinema_Ticketing.domain.updateRequests.UpdateTicketOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {TicketMapper.class})
public interface TicketOrderMapper {

    CreateTicketOrderRequest fromDto(CreateTicketOrderRequestDto dto);

    CreateTicketOrderResponseDto toDto(TicketOrder ticketOrder);

    ListTicketResponseDto toDto(Ticket ticket);

    ListTicketOrderResponseDto toListTicketOrderResponseDto(TicketOrder ticketOrder);

    GetTicketResponseDto toGetTicketOrderTicketResponseDto(Ticket ticket);

    GetTicketOrderResponseDto toGetTicketOrderResponseDto(TicketOrder ticketOrder);

    UpdateTicketOrderRequest fromDto(UpdateTicketOrderRequestDto dto);

    UpdateTicketOrderResponseDto toUpdatedTicketOrderResponseDto(TicketOrder ticketOrder);
}
