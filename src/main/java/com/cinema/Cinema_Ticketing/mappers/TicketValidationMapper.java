package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketValidationRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketValidationRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketValidationResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketValidation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketValidationMapper {
    CreateTicketValidationRequest fromDto(CreateTicketValidationRequestDto ticketValidationRequestDto);

    CreateTicketValidationResponseDto toDto(TicketValidation ticketValidation);
}
