package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateScreeningRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateScreeningResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ScreeningSeatMapper.class, TicketOrderMapper.class})
public interface ScreeningMapper {

    CreateScreeningRequest fromDto(CreateScreeningRequestDto dto);

    CreateScreeningResponseDto toDto(Screening screening);
}
