package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreatedTicketValidationResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketValidation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketValidationMapper {

    CreatedTicketValidationResponseDto toDto(TicketValidation ticketValidation);
}
