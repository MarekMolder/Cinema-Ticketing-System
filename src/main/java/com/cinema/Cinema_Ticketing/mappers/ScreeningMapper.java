package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.CreateScreeningRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateScreeningRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateScreeningResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ScreeningSeatMapper.class, TicketOrderMapper.class})
public interface ScreeningMapper {

    CreateScreeningRequest fromDto(CreateScreeningRequestDto dto);

    @Mapping(source = "movie.id", target = "movieId")
    CreateScreeningResponseDto toDto(Screening screening);
}
